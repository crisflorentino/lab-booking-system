package com.labbooking.lbsys.model;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    private long id;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {}

    public User(long id, Role role) {
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
