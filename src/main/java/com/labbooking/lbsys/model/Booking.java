package com.labbooking.lbsys.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Equipment equipment;

    @ManyToOne
    private User user;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    // Getters
    public LocalDateTime getEndTime() { return endTime; }
    public LocalDateTime getStartTime() { return startTime; }
    public User getUser() { return user; }
    public Equipment getEquipment() { return equipment; }
    public long getId() { return id; }

    // Setters

    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public void setUser(User user) { this.user = user; }

    public void setEquipment(Equipment equipment) { this.equipment = equipment; }

    public void setId(long id) { this.id = id; }
}
