package com.example.demo.service;

import com.example.demo.dto.BookingRequest;
import com.example.demo.entity.Booking;
import com.example.demo.entity.ReservationRequest;
import com.example.demo.entity.Restaurant;
import com.example.demo.entity.User;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class BookingService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    RestaurantService restaurantService;

    public Long bookRestaurant(BookingRequest bookingRequest){

        User user= userRepository.getUserDetails(bookingRequest.getUserId());
        Restaurant restaurant=restaurantService.getRestaurantDetails(bookingRequest.getRestaurantId());


        Booking booking = generateBookingRequest(bookingRequest,user,restaurant);


        return booking.getBookingId();
    }

    public Booking generateBookingRequest(BookingRequest bookingRequest, User user, Restaurant restaurant) {
        Booking booking=new Booking();
        booking.setNumberOfGuests(bookingRequest.getNumberOfGuests());
        booking.setCustomer(user);
        booking.setLocalDateTime(LocalDateTime.now());
        ReservationRequest reservationRequest=new ReservationRequest();
        booking.setReservationRequest(reservationRequest);
        //booking.setCustomer();
        return booking;
    }
}
