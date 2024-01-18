package com.ismasurance.ismasurance.claim.api.v1.dto;

import lombok.Data;

@Data
public class SearchClaimRequest {
    private String claClaim;
    private String claPolicy;
    private String handlerName;
}
