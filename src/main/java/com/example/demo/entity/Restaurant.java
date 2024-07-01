package com.example.demo.entity;


import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = false)
    private User manager;

    private String name;
    private String cuisines;
    private String location;
    private String workingDays;
    private String workingHours;
    private String timeSlotInterval;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "restaurant")
    private List<RestaurantTable> tables;

    @OneToMany(mappedBy = "restaurant")
    private List<Booking> bookings;
}
