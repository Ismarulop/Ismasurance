package com.ismasurance.ismasurance.claim.service;

import com.ismasurance.ismasurance.claim.api.v1.dto.ClaimRequest;
import com.ismasurance.ismasurance.claim.api.v1.dto.ClaimResponse;

import java.util.List;

public interface ClaimService {
    List<ClaimResponse> getClaims();

    ClaimResponse createClaim(ClaimRequest request);
}
