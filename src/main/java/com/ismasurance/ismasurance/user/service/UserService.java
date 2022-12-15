package com.ismasurance.ismasurance.user.service;

import com.ismasurance.ismasurance.user.api.v1.dto.UserRequest;
import com.ismasurance.ismasurance.user.api.v1.dto.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest user);

    UserResponse signInValidation(UserRequest user);
}
