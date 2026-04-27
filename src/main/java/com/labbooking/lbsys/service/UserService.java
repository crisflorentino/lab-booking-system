package com.labbooking.lbsys.service;


import com.labbooking.lbsys.model.Role;
import com.labbooking.lbsys.model.User;
import com.labbooking.lbsys.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository uRepo;

    public UserService(UserRepository uRepo) {
        this.uRepo = uRepo;
    }

    public User createUser(User newUser) {
        // Throw if there is no ID provided, one has to be assigned because one isn't automatically provided.
        if (newUser.getId() == 0L) {
            throw new IllegalArgumentException("User creation failed: No ID provided.");
        }

        // Automatically provide with the role USER if one isn't provided.
        if (newUser.getRole() == null) {
            newUser.setRole(Role.USER);
        }

        // Prevent the creation of users with duplicate IDs.
        if (newUser.getId() != 0L && uRepo.existsById(newUser.getId())) {
            uRepo.existsById(newUser.getId());
        }

        return uRepo.save(newUser);
    }

    public User updateUser(Long id, User updatedInfo) {
        Optional<User> existingUser = uRepo.findById(id);

        // Check if the user was actually found.
        if (existingUser.isEmpty()) {
            throw new RuntimeException("User update failed: User ID " + id + " does not exist.");
        }

        User user = existingUser.get();

        // Update each field.
        if (updatedInfo.getId() != 0L) {
            user.setId(updatedInfo.getId());
        }

        if (updatedInfo.getRole() != null) {
            user.setRole(updatedInfo.getRole());
        }

        return uRepo.save(user);
    }

    public User getById(Long id) {
        Optional<User> existingUser = uRepo.findById(id);

        if (existingUser.isEmpty()) {
            throw new RuntimeException("User fetch failed: User ID" + id + " does not exist.");
        }

        return existingUser.get();
    }

    public List<User> getAllUsers() {
        return uRepo.findAll();
    }

    public void deleteUser(Long id) {
        if (!uRepo.existsById(id)) {
            throw new RuntimeException("Deletion failed: User ID " + id + " does not exist.");
        }

        uRepo.deleteById(id);
    }
}
