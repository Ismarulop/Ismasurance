package com.ismasurance.ismasurance.user.api.v1.dto;

import lombok.Data;

@Data
public class UserResponse {
    private String userName;
    private String email;
    private String phone;
    private String countryCode;
    private String country;
}
