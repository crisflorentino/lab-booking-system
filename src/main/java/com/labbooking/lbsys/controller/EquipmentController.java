package com.labbooking.lbsys.controller;

import com.labbooking.lbsys.model.Equipment;
import com.labbooking.lbsys.model.Status;
import com.labbooking.lbsys.service.EquipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {
    private final EquipmentService eService;

    public EquipmentController(EquipmentService eService) {
        this.eService = eService;
    }

    @GetMapping
    public List<Equipment> getAllEquipment() {
        return eService.getAllEquipment();
    }

    @GetMapping("/status")
    public List<Equipment> getByStatus(@RequestParam Status status) {
       return eService.getEquipmentByStatus(status);
    }

    @GetMapping("/{id}")
    public Equipment getById(@PathVariable Long id) {
        return eService.getEquipmentById(id);
    }

    @PostMapping
    public Equipment addEquipment(@RequestBody Equipment equipment) {
        return eService.addEquipment(equipment);
    }

    @PutMapping("/{id}/status")
    public Equipment updateStatus(@PathVariable Long id, @RequestParam Status newStatus) {
        return eService.updateEquipmentStatus(id, newStatus);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipment(@PathVariable Long id) {
        eService.deleteEquipment(id);
    }
}
