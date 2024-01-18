package com.ismasurance.ismasurance.user.api.v1.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class UserResponse {
    private BigInteger id;
    private String userId;
    private String userName;
    private String email;
    private String phone;
    private String countryCode;
    private String country;
}
