package com.labbooking.lbsys.repository;

import com.labbooking.lbsys.model.Equipment;
import com.labbooking.lbsys.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    // Custom method to be able to search strictly by status.
    List<Equipment> findByStatus(Status status);
}
