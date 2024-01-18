package com.ismasurance.ismasurance.user.api.v1.dto;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;

@Data
public class UserSignInRequest {
    @NotBlank(message= "email")
    private String email;
    @NotBlank(message= "password")
    private String password;
}
