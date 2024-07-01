package com.example.demo.service;

import com.example.demo.entity.Booking;
import com.example.demo.entity.ReservationRequest;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    ReservationRepository reservationRepository;

    public Long requestForResrvation(ReservationRequest reservationRequest) {

        ReservationRequest reserve=reservationRepository.save(reservationRequest);

        return reserve.getRequestId();


    }

    public List<ReservationRequest> fetchReservationList() {

        return reservationRepository.findAll();
    }
}
