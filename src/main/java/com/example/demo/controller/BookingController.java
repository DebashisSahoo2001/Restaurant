package com.example.demo.controller;

import com.example.demo.dto.BookingRequest;
import com.example.demo.entity.Booking;
import com.example.demo.service.BookingService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/bookRestaurant/reserve/{bookingId}")
    public String bookRestaurant(@PathVariable Long bookingId) {//Only manager
        Long reserveId=bookingService.reserveRestaurant(bookingId);
        if(reserveId!=null) {
            return "Reservation done successfully with reserve id id - " + reserveId;
        }else{
            return "Failed to create reservation";
        }
    }

    @GetMapping("/cancelBooking/{bookingId}")
    public String cancelBooking(@PathVariable Long bookingId) {
        try{
            bookingService.cancelBooking(bookingId);
            return "Booking created successfully with booking id - "+ bookingId;

        }catch (Exception e){
            e.printStackTrace();
            return "Booking created successfully with booking id - "+ bookingId;
        }
    }

    @GetMapping("/getAllBookings")
    public String getBooking() {
        List<Booking> bookingList=bookingService.fetchBookingList();
        Gson gson = new Gson();


        return gson.toJson(bookingList);
    }
}
