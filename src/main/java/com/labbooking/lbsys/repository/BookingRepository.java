package com.labbooking.lbsys.repository;

import com.labbooking.lbsys.model.Booking;
import com.labbooking.lbsys.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId);

    // PostgreSQL query that checks if there are any existing bookings for a piece of equipment that overlaps with current start and end times.
    @Query("SELECT COUNT(b) > 0 FROM Booking b WHERE b.equipment = :equipment " + "AND b.startTime < :endTime AND b.endTime > :startTime")
    boolean hasTimeConflict(
            @Param("equipment") Equipment equipment,
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime
    );
}
