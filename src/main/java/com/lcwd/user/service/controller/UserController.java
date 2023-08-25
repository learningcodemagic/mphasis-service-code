package com.lcwd.user.service.controller;

import com.lcwd.user.service.entity.User;
import com.lcwd.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        logger.info("User request for {}",user);
        User newCreatedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCreatedUser);
    }
    @GetMapping("/{name}")
    public ResponseEntity<User > getSingleUser(@PathVariable String name){
        logger.info("fetching user for ID : {}",name);
        User  user = userService.getUser(name);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getSingleUser(){
        logger.info("fetching all user request submitted successfully");
       List<User> user = userService.getAllUser();
        return ResponseEntity.ok(user);
    }



}
