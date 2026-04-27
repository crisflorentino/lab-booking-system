package com.labbooking.lbsys.model;

import jakarta.persistence.*;


@Entity
@Table(name = "equipment")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Equipment() {}

    // Getters
    public long getId() { return id; }
    public String getName() { return name; }
    public Status getStatus() { return status; };

    // Setters
    public void setId(long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setStatus(Status status) { this.status = status; }
}
