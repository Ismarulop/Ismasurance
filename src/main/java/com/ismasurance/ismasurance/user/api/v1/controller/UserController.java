package com.ismasurance.ismasurance.user.api.v1.controller;

import com.ismasurance.ismasurance.user.api.v1.dto.UserRequest;
import com.ismasurance.ismasurance.user.api.v1.dto.UserResponse;
import com.ismasurance.ismasurance.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping(value = "/hello")
//    public String home() {
//        return "Hello World";
//    }

    @PostMapping("/createUser")
    public ResponseEntity<UserResponse> newUser(@RequestBody UserRequest user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }

    @PostMapping("/signIn")
    public ResponseEntity<UserResponse> validateSignInUser(@RequestBody UserRequest user) {

        return new ResponseEntity<>(userService.signInValidation(user), HttpStatus.OK);
    }
}
