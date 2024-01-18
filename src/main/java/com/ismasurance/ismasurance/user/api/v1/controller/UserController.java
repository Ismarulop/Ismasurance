package com.ismasurance.ismasurance.user.api.v1.controller;

import com.ismasurance.ismasurance.user.api.v1.dto.UserRequest;
import com.ismasurance.ismasurance.user.api.v1.dto.UserResponse;
import com.ismasurance.ismasurance.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getUsers")
    public  ResponseEntity<List<UserResponse>> getUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
 @GetMapping(value = "/getUser")
    public ResponseEntity<UserResponse> getUser(@RequestParam String email) {
     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//     String emailAddress = authentication.getPrincipal().toString();
     return new ResponseEntity<>(userService.getUser(email), HttpStatus.OK);
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserResponse> newUser(@RequestBody UserRequest user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }


}
