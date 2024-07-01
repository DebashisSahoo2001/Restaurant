package com.example.demo.repository;

import com.example.demo.entity.ReservationRequest;
import com.example.demo.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationRequest, Long> {
    List<ReservationRequest> findByRestaurant(Restaurant restaurant);

    List<ReservationRequest> findByRestaurantId(Long id);

}
