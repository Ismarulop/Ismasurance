package com.ismasurance.ismasurance.claim.service;

import com.ismasurance.ismasurance.claim.api.v1.dto.ClaimRequest;
import com.ismasurance.ismasurance.claim.api.v1.dto.ClaimResponse;
import com.ismasurance.ismasurance.claim.api.v1.mapper.ClaimMapper;
import com.ismasurance.ismasurance.claim.data.ClaimEntity;
import com.ismasurance.ismasurance.claim.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClaimServiceImpl implements ClaimService{

    @Autowired
    private ClaimRepository claimRepository;
    @Autowired
    private ClaimMapper claimMapper;
    @Override
    public List<ClaimResponse> getClaims() {
        List<ClaimEntity> claimList = claimRepository.findAll();
        List<ClaimResponse> response = new ArrayList<>();
        for (ClaimEntity claim : claimList) {
            ClaimResponse claimResponse= claimMapper.claimEntityToClaimResponse(claim);
            response.add(claimResponse);
        }
        return response;
    }

    @Override
    public ClaimResponse createClaim(ClaimRequest request) {
        ClaimEntity claim = claimMapper.claimRequestToClaimEntity(request);
        claimRepository.save(claim);
        ClaimResponse response = claimMapper.claimEntityToClaimResponse(claim);
        return response;
    }
}
