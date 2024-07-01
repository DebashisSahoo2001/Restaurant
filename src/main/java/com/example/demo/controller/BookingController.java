package com.example.demo.controller;

import com.example.demo.dto.BookingRequest;
import com.example.demo.entity.Booking;
import com.example.demo.entity.Restaurant;
import com.example.demo.service.BookingService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/bookRestaurant")
    public String bookRestaurant(@RequestBody BookingRequest bookingRequest) {
        Long bookingId=bookingService.bookRestaurant(bookingRequest);
        return "Booking created successfully with booking id - "+ bookingId;
    }

    @GetMapping("/getBookings")
    public String getBooking() {
        Gson gson = new Gson();


        //return gson.toJson(restaurantList);
        return "";
    }
}
