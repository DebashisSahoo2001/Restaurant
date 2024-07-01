package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("Select u from User u where u.userId=:userId")
    User getUserDetails(@Param("userId") Long userId);

    @Query("Select u from User u where u.userName=:userName and u.password=:password")
    User verifyUserDetails(@Param("userName") String userName,@Param("password") String password);


    Optional<User> findByEmail(String email);
}
