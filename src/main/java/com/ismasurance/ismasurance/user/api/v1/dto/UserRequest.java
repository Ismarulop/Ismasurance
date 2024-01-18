package com.ismasurance.ismasurance.user.api.v1.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;


@Data
public class UserRequest {
    @NotBlank(message= "userId is required")
    private String userId;
    @NotBlank(message= "userName is required")
    private String userName;
    @NotBlank(message= "password is required")
    private String password;
    private String email;
    private String phone;
    private String countryCode;
    private String country;
}
