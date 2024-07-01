package com.example.demo.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
public class ReservationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
