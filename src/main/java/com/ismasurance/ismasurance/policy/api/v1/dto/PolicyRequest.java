package com.ismasurance.ismasurance.policy.api.v1.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PolicyRequest {

    @NotBlank(message="insuranceName")
    private String insuranceName;
}
