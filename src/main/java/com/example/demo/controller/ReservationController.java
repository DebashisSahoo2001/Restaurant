package com.example.demo.controller;

import com.example.demo.dto.BookingRequest;
import com.example.demo.entity.Booking;
import com.example.demo.entity.ReservationRequest;
import com.example.demo.entity.Restaurant;
import com.example.demo.service.BookingService;
import com.example.demo.service.ReservationService;
import com.google.gson.Gson;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    ReservationService reservationService;


    @GetMapping("/getReservationss")
    public String getReservationList() {
        List<ReservationRequest> reserveList=reservationService.fetchReservationList();
        Gson gson = new Gson();
        return gson.toJson(reserveList);
    }
}
