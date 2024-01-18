package com.ismasurance.ismasurance.claim.api.v1.controller;

import com.ismasurance.ismasurance.claim.api.v1.dto.ClaimRequest;
import com.ismasurance.ismasurance.claim.api.v1.dto.ClaimResponse;
import com.ismasurance.ismasurance.claim.api.v1.dto.SearchClaimRequest;
import com.ismasurance.ismasurance.claim.service.ClaimService;
import com.ismasurance.ismasurance.validations.ClaimValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/claim")
@CrossOrigin
public class ClaimController {
    @Autowired
    private ClaimService claimService;
    @Autowired
    private ClaimValidations claimValidations;

    @PostMapping("/searchClaim")
    public ResponseEntity<List<ClaimResponse>> getClaim(@RequestBody SearchClaimRequest searchClaimRequest) {
        List<ClaimResponse> response = claimService.getClaim(searchClaimRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/claims")
    public ResponseEntity<List<ClaimResponse>> getClaims() {
        List<ClaimResponse> response = claimService.getClaims();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/newClaim")
    public ResponseEntity<ClaimResponse> createClaim(@RequestBody ClaimRequest request) {
        claimValidations.createClaimValidations(request);
        ClaimResponse response = claimService.createClaim(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/deleteClaim/{idClaim}")
    public ResponseEntity<String> deleteClaim(@PathVariable String idClaim) {
        String response = claimService.deleteClaim(idClaim);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/updateClaim/{idClaim}")
    public ResponseEntity<String> updateClaim(@PathVariable String idClaim,
                                              @RequestBody ClaimRequest request) {
        String response = claimService.updateClaim(idClaim,request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
