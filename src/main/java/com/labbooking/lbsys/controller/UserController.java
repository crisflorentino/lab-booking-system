package com.labbooking.lbsys.controller;

import com.labbooking.lbsys.model.User;
import com.labbooking.lbsys.service.UserService;
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

    private final UserService uService;
    public UserController(UserService uService) {
        this.uService = uService;
    }

    // Returns a list of all the user objects within the database
    @GetMapping
    public List<User> getAllUsers() {
        return uService.getAllUsers();
    }

    // Returns a specific user based on the ID provided.
    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable Long id) {
        return Optional.ofNullable(uService.getById(id));
    }

    // Creates and saves a new user object to the database. 
    @PostMapping
    public User createUser(@RequestBody User user) {
        return uService.createUser(user);
    }

    // Deletes a specific user from the database based on the ID provided.
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        uService.deleteUser(id);
    }

    // Update a specific user from the database.
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return uService.updateUser(id, updatedUser);
    }
}
