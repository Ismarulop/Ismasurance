package com.ismasurance.ismasurance.claim.api.v1.controller;

import com.ismasurance.ismasurance.claim.api.v1.dto.ClaimRequest;
import com.ismasurance.ismasurance.claim.api.v1.dto.ClaimResponse;
import com.ismasurance.ismasurance.claim.service.ClaimService;
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

    @GetMapping("/claims")
    public ResponseEntity<List<ClaimResponse>> getClaims(){
        List<ClaimResponse> response = claimService.getClaims();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/newClaim")
    public ResponseEntity<ClaimResponse> createClaim(@RequestBody ClaimRequest request) {
        ClaimResponse response = claimService.createClaim(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
