package com.labbooking.lbsys.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {}

    public User(Long id, Role role) {
        this.id = id;
        this.role = role;
    }

    // Getters
    public long getId() { return this.id; }
    public Role getRole() { return this.role; }

    // Setters
    public void setId(long id) { this.id = id; }
    public void setRole(Role role) { this.role = role; }
}
