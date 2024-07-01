package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Implement login logic here to get Jwt token and return jwt token
        String jwt="";
        User user=userService.verifyCredential(username,password);
        if(user!=null){
            return "Login successful and jwt token is"+jwt;
        }else{
            return "invalid credentials";
        }

    }

}
