package com.ismasurance.ismasurance.claim.service;

import com.ismasurance.ismasurance.claim.api.v1.dto.ClaimRequest;
import com.ismasurance.ismasurance.claim.api.v1.dto.ClaimResponse;
import com.ismasurance.ismasurance.claim.api.v1.dto.SearchClaimRequest;

import java.util.List;

public interface ClaimService {
    List<ClaimResponse> getClaims();

    ClaimResponse createClaim(ClaimRequest request);

    String deleteClaim(String idClaim);

    String updateClaim(String idClaim, ClaimRequest request);

    List<ClaimResponse> getClaim(SearchClaimRequest searchClaimRequest);
}
