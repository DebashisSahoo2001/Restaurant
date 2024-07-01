package com.example.demo.controller;

import com.example.demo.entity.Restaurant;
import com.example.demo.service.RestaurantService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;


    @PostMapping("/registerRestaurant")
    public String register(@RequestBody Restaurant restaurant) {
        Restaurant registeredUser = restaurantService.registerRestaurant(restaurant);
        return "Restaurant registered successfully";
    }

    @GetMapping("/getRestaurants")
    public String getRest() {
        // Implement login logic here to get Jwt token
         List<Restaurant> restaurantList=restaurantService.getAllRestaurantDetails();
         Gson gson = new Gson();

        return gson.toJson(restaurantList);
    }
}
