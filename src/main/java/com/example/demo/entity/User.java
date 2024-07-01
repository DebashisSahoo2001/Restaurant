package com.example.demo.entity;


import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(unique = true)
    private String email;

    private String password;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "manager")
    private List<Restaurant> restaurants;

    @OneToMany(mappedBy = "customer")
    private List<Booking> bookings;
}


