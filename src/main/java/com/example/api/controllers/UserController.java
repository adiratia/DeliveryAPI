package com.example.api.controllers;

import com.example.api.model.User;
import com.example.api.reposetories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    public UserRepository userRepository;
    //Get all users
    @GetMapping(value = "/getusers")
    public List<User> getUsers(){
        return userRepository.findAll();

    }
    //Create new user
    @PostMapping(value= "/createuser")
    public String createUser(@RequestBody User user){
        User insertedUser = userRepository.insert(user);
        return "User created";
    }
}
