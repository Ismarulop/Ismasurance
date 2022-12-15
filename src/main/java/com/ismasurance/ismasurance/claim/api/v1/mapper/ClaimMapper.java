package com.ismasurance.ismasurance.claim.api.v1.mapper;

import com.ismasurance.ismasurance.claim.api.v1.dto.ClaimRequest;
import com.ismasurance.ismasurance.claim.api.v1.dto.ClaimResponse;
import com.ismasurance.ismasurance.claim.data.ClaimEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper
public interface ClaimMapper {
    @Named("ClaimRequestToClaimEntity")
    ClaimEntity claimRequestToClaimEntity(ClaimRequest request);

    @Named("ClaimEntityToClaimResponse")
    ClaimResponse claimEntityToClaimResponse(ClaimEntity request);
}
