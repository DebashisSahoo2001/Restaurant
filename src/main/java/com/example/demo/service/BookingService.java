package com.example.demo.service;

import com.example.demo.dto.BookingRequest;
import com.example.demo.entity.*;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    RestaurantService restaurantService;
    @Autowired
    private ReservationRepository reservationRepository;

    public Long bookRestaurant(BookingRequest bookingRequest){

        User user= userRepository.getUserDetails(bookingRequest.getUserId());
        Restaurant restaurant=restaurantService.getRestaurantDetails(bookingRequest.getRestaurantId());


        Booking booking = generateBookingRequest(bookingRequest,user,restaurant);
        if(user.getRole().equals(Role.MANAGER)){
            booking.setStatus(Status.CONFIRMED);
            bookingRepository.save(booking);

            ReservationRequest reservationRequest=new ReservationRequest();
            reservationRequest.setBooking(booking);
            reservationRequest.setStatus(Status.CONFIRMED);
            reservationRequest.setCreatedAt(LocalDateTime.now());
            reservationRequest.setUpdatedAt(LocalDateTime.now());

            reservationRepository.save(reservationRequest);
            //booking.setReservationRequest(reservationRequest);
        }else
        {
            booking.setStatus(Status.PENDING);
            bookingRepository.save(booking);
        }



        return booking.getBookingId();
    }

    public Booking generateBookingRequest(BookingRequest bookingRequest, User user, Restaurant restaurant) {
        Booking booking=new Booking();
        booking.setNumberOfGuests(bookingRequest.getNumberOfGuests());
        booking.setCustomer(user);
        booking.setLocalDateTime(LocalDateTime.now());
        booking.setCreatedAt(LocalDateTime.now());
        booking.setTimeSlot(bookingRequest.getTimeSlot());

        return booking;
    }

    public List<Booking> fetchBookingList() {
        List<Booking> bookingList = bookingRepository.findAll();
        return bookingList;
    }

    public Long cancelBooking(Long bookingId) {

        Optional<Booking> bookingObj=bookingRepository.findById(bookingId);


        if(bookingObj.isPresent()){
            Booking booking=bookingObj.get();
            booking.setStatus(Status.CANCELLED);
            booking.setUpdatedAt(LocalDateTime.now());
            bookingRepository.save(booking);

            ReservationRequest reservationRequest=new ReservationRequest();
            reservationRequest.setBooking(booking);
            reservationRequest.setStatus(Status.CANCELLED);
            //reservationRequest.setCreatedAt(LocalDateTime.now());
            reservationRequest.setUpdatedAt(LocalDateTime.now());

            ReservationRequest reserve=reservationRepository.save(reservationRequest);

            return reserve.getRequestId();

        }else{
            return null;
        }
    }

    public Long reserveRestaurant(Long bookingId) {

        Optional<Booking> bookingObj=bookingRepository.findById(bookingId);


        if(bookingObj.isPresent()){
            Booking booking=bookingObj.get();
            booking.setStatus(Status.CONFIRMED);
            bookingRepository.save(booking);

            ReservationRequest reservationRequest=new ReservationRequest();
            reservationRequest.setBooking(booking);
            reservationRequest.setStatus(Status.CONFIRMED);
            reservationRequest.setCreatedAt(LocalDateTime.now());
            reservationRequest.setUpdatedAt(LocalDateTime.now());

            ReservationRequest reserve=reservationRepository.save(reservationRequest);

            return reserve.getRequestId();

        }else{
            return null;
        }

    }
}
