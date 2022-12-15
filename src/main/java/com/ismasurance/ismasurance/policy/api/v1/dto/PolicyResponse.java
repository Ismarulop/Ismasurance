package com.ismasurance.ismasurance.policy.api.v1.dto;

import lombok.Data;

@Data
public class PolicyResponse {

    private String policyId;
    private String clnPolicy;
    private String claPolicy;
    private String insuranceName;
}
