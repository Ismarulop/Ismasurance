package com.ismasurance.ismasurance.user.service;

import com.ismasurance.ismasurance.user.api.v1.dto.UserRequest;
import com.ismasurance.ismasurance.user.api.v1.dto.UserResponse;
import com.ismasurance.ismasurance.user.api.v1.dto.UserSignInRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserResponse createUser(UserRequest user);

    UserResponse getUser(String email);

    List<UserResponse> getAllUsers();

    UserDetails signInValidation(UserSignInRequest userSignInRequest);
}
