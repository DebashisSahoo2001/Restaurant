package com.example.demo.repository;

import com.example.demo.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("Select r from Restaurant  r where r.restaurantId=:restaurantId")
    Restaurant getRestaurantDetails(@Param("restaurantId") Long restaurantId);
}