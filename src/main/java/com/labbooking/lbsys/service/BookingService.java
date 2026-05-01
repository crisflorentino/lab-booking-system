package com.labbooking.lbsys.service;


import com.labbooking.lbsys.model.Booking;
import com.labbooking.lbsys.model.Equipment;
import com.labbooking.lbsys.model.User;
import com.labbooking.lbsys.repository.BookingRepository;
import com.labbooking.lbsys.repository.EquipmentRepository;
import com.labbooking.lbsys.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository bRepo;
    private final EquipmentRepository eRepo;
    private final UserRepository uRepo;

    public BookingService(BookingRepository bRepo, UserRepository uRepo, EquipmentRepository eRepo) {
        this.bRepo = bRepo;
        this.eRepo = eRepo;
        this.uRepo = uRepo;
    }

    public Booking createBooking(Booking newBooking) {
        // Verifying that the times are valid.
        if (newBooking.getStartTime() == null || newBooking.getEndTime() == null) {
            throw new IllegalArgumentException("Booking creation failed: Start time or end time is null.");
        }
        if (newBooking.getStartTime().isAfter(newBooking.getEndTime())) {
            throw new IllegalArgumentException("Booking creation failed: Start time is after the provided end time.");
        }
        if (newBooking.getStartTime().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Booking creation failed: Start time is a a time that has already passed.");
        }

        // Verifying that the user creating the booking actually exists.
        Optional<User> userOptional = uRepo.findById(newBooking.getUser().getId());
        if (userOptional.isEmpty()) {
            throw new RuntimeException("Booking creation failed: User ID provided does not exist within the database.");
        }

        // Verifying that the equipment being booked actually exists.
        Optional<Equipment> equipmentOptional = eRepo.findById(newBooking.getEquipment().getId());
        if (equipmentOptional.isEmpty()) {
            throw new RuntimeException("Booking creation failed: User ID provided does not exist within the database.");
        }

        // Checking for potential time conflictions.
        boolean isConflict = bRepo.hasTimeConflict(
                equipmentOptional.get(),
                newBooking.getStartTime(),
                newBooking.getEndTime()
        );

        if (isConflict) {
            throw new RuntimeException("Booking creation failed: The equipment is already booked for this time.");
        }

        newBooking.setUser(userOptional.get());
        newBooking.setEquipment(equipmentOptional.get());

        return bRepo.save(newBooking);
    }

    public Booking getById(Long id) {
        Optional<Booking> bookingOptional = bRepo.findById(id);

        if (bookingOptional.isEmpty()) {
            throw new RuntimeException("Booking fetch failed: ID " + id + " does not exist within the database.");
        }

        return bookingOptional.get();
    }

    public List<Booking> getBookingsByUser(Long userId) {
        if (!uRepo.existsById(userId)) {
            throw new RuntimeException("Bookings fetch failed: User ID " + userId + " was not found.");
        }

        return bRepo.findByUserId(userId);
    }

    public void cancelBooking(Long id) {
        if (!bRepo.existsById(id)) {
            throw new RuntimeException("Booking cancellation failed: Booking ID "+ id + " was not found.");
        }

        bRepo.deleteById(id);
    }

    public List<Booking> getAllBookings() {
        return bRepo.findAll();
    }


}
