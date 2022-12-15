package com.ismasurance.ismasurance.user.api.v1.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;


@Data
public class UserRequest {
    @NotBlank(message= "userName")
    private String userName;
    @NotBlank(message= "password")
    private String password;
    private String email;
    private String phone;
    private String countryCode;
    private String country;
}
