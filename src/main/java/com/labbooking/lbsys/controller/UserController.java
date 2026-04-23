package com.labbooking.lbsys.controller;

import com.labbooking.lbsys.model.User;
import com.labbooking.lbsys.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    // This is temporary, later we will move this to a service class.
    private final UserRepository uRepo;

    public UserController(UserRepository uRepo) {
        this.uRepo = uRepo;
    }

    // Returns a list of all the user objects within the database
    @GetMapping
    public List<User> getAllUsers() {
        return uRepo.findAll();
    }

    // Returns a specific user based on the ID provided.
    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable Long id) {
        return uRepo.findById(id);
    }

    // Creates and saves a new user object to the database. 
    @PostMapping
    public User createUser(@RequestBody User user) {
        return uRepo.save(user);
    }

    // Deletes a specific user from the database based on the ID provided.
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        // Should probably throw something if the ID just doesn't exist but I'll do that another time.
        if (uRepo.existsById(id)) {
            uRepo.deleteById(id);
        }
    }
}
