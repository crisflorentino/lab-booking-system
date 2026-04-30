package com.labbooking.lbsys.service;


import com.labbooking.lbsys.model.Equipment;
import com.labbooking.lbsys.model.Status;
import com.labbooking.lbsys.repository.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {
    private final EquipmentRepository eRepo;

    public EquipmentService(EquipmentRepository eRepo) {
        this.eRepo = eRepo;
    }

    public Equipment addEquipment(Equipment newEquipment) {

        // If no status is provided, make the status automatically maintenance.
        if (newEquipment.getStatus() == null) {
            newEquipment.setStatus(Status.MAINTENANCE);
        }

        return eRepo.save(newEquipment);
    }

    public Equipment updateEquipmentStatus(Long id, Status newStatus) {
        Optional<Equipment> existingEquipment = eRepo.findById(id);

        if (existingEquipment.isEmpty()) {
            throw new RuntimeException("Equipment update failed: ID " + id + " does not exist.");
        }

        Equipment equipment = existingEquipment.get();
        equipment.setStatus(newStatus);

        return eRepo.save(equipment);
    }

    public Equipment getEquipmentById(Long id) {
        Optional<Equipment> existingEquipment = eRepo.findById(id);

        if (existingEquipment.isEmpty()) {
            throw new RuntimeException("Equipment fetch failed: ID " + id + " does not exist.");
        }

        return existingEquipment.get();
    }

    public List<Equipment> getAllEquipment() {
        return eRepo.findAll();
    }

    public void deleteEquipment(Long id) {
        // TODO: Check if equipment is linked to an active booking, do not allow deletion if this is the case.
        if (!eRepo.existsById(id)) {
            throw new RuntimeException("Equipment deletion failed: ID " + id + " does not exist.");
        }

        eRepo.deleteById(id);
    }

    public List<Equipment> getEquipmentByStatus(Status status) {
        return eRepo.findByStatus(status);
    }
}
