package com.example.demo.service;

import com.example.demo.entity.Restaurant;
import com.example.demo.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;


    public Restaurant registerRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getAllRestaurantDetails() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantDetails(Long restaurantId) {

        return restaurantRepository.getRestaurantDetails(restaurantId);
    }
}
