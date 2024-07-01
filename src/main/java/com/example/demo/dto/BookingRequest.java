package com.example.demo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingRequest {

    private LocalDateTime date;
    private int numberOfGuests;
    private String timeSlot;
    private Long restaurantId;
    private Long userId;
}
