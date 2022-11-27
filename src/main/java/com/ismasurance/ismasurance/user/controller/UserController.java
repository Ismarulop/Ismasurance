package com.ismasurance.ismasurance.user.controller;

import com.ismasurance.ismasurance.user.model.UserEntity;
import com.ismasurance.ismasurance.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public String home() {
        return "Hello World";
    }

    @PostMapping("/createUser")
    public String newUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }
}
