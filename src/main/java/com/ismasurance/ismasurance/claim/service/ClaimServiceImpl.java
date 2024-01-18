package com.ismasurance.ismasurance.claim.service;

import com.ismasurance.ismasurance.claim.api.v1.dto.ClaimRequest;
import com.ismasurance.ismasurance.claim.api.v1.dto.ClaimResponse;
import com.ismasurance.ismasurance.claim.api.v1.dto.SearchClaimRequest;
import com.ismasurance.ismasurance.claim.api.v1.mapper.ClaimMapper;
import com.ismasurance.ismasurance.claim.data.ClaimEntity;
import com.ismasurance.ismasurance.claim.repository.ClaimRepository;
import com.ismasurance.ismasurance.exception.ClaimNotExistException;
import com.ismasurance.ismasurance.policy.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private PolicyRepository policyRepository;
    @Autowired
    private ClaimMapper claimMapper;

    @Override
    public List<ClaimResponse> getClaims() {
        List<ClaimEntity> claimList = claimRepository.findAll();
        List<ClaimResponse> response = new ArrayList<>();
        for (ClaimEntity claim : claimList) {
            ClaimResponse claimResponse = claimMapper.claimEntityToClaimResponse(claim);
            response.add(claimResponse);
        }
        return response;
    }

    @Override
    public ClaimResponse createClaim(ClaimRequest request) {
        Date currentDate = new Date();
        ClaimEntity claim = claimMapper.claimRequestToClaimEntity(request);
        claim.setClaimDate(currentDate);
        claimRepository.save(claim);

        return claimMapper.claimEntityToClaimResponse(claim);
    }

    @Override
    public String deleteClaim(String idClaim) {
        Optional<ClaimEntity> claimEntity = claimRepository.findById(idClaim);
        if (claimEntity.isPresent()) {
            claimRepository.delete(claimEntity.get());
        } else {
            throw new ClaimNotExistException("There is not a claim with this id: " + idClaim, HttpStatus.NO_CONTENT);
        }

        return "Claim " + idClaim + " has been deleted";
    }

    @Override
    public String updateClaim(String idClaim, ClaimRequest request) {
        Optional<ClaimEntity> claimEntity = claimRepository.findById(idClaim);
        if (claimEntity.isPresent()) {
            claimEntity.get().setClaPolicy(request.getClaPolicy());
            claimEntity.get().setTxtClaim(request.getTxtClaim());
            claimRepository.save(claimEntity.get());
        } else {
            throw new ClaimNotExistException("There is not a claim with this id: " + idClaim, HttpStatus.NO_CONTENT);
        }

        return "Claim " + idClaim + " has been modified";
    }

    @Override
    public List<ClaimResponse> getClaim(SearchClaimRequest searchClaimRequest) {
        List<ClaimResponse> claimsList = new ArrayList<>();
        List<ClaimEntity> claims = claimRepository.getClaimByRequest(searchClaimRequest);
        if (claims.isEmpty()) {
            throw new RuntimeException("No claim with this search");
        }
        for (ClaimEntity claim : claims) {
            ClaimResponse claimResponse = claimMapper.claimEntityToClaimResponse(claim);
            claimsList.add(claimResponse);
        }
        return claimsList;
    }
}
