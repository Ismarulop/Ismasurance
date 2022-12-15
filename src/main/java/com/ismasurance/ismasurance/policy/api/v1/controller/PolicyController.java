package com.ismasurance.ismasurance.policy.api.v1.controller;

import com.ismasurance.ismasurance.policy.api.v1.dto.PolicyRequest;
import com.ismasurance.ismasurance.policy.api.v1.dto.PolicyResponse;
import com.ismasurance.ismasurance.policy.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/policy")
@CrossOrigin
public class PolicyController {
    @Autowired
    private PolicyService policyService;

    @PostMapping("/createPolicy")
    public ResponseEntity<PolicyResponse> newPolicy(@RequestBody PolicyRequest request) {
        return new ResponseEntity<>(policyService.createPolicy(request), HttpStatus.OK);
    }

    @GetMapping("/getPolicyByName")
    public ResponseEntity<PolicyResponse> getPolicyByName(@RequestBody PolicyRequest request) {
        return new ResponseEntity<>(policyService.getPolicyByName(request), HttpStatus.OK);
    }
}
