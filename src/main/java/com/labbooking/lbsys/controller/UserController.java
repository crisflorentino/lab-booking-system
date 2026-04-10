package com.labbooking.lbsys.controller;

import com.labbooking.lbsys.model.User;
import com.labbooking.lbsys.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    // This is temporary, later we will move this to a service class.
    private final UserRepository uRepo;

    public UserController(UserRepository uRepo) {
        this.uRepo = uRepo;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return uRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable Long id) {
        return uRepo.findById(id);
    }
}
