package com.ismasurance.ismasurance.policy.service;

import com.ismasurance.ismasurance.policy.api.v1.dto.PolicyRequest;
import com.ismasurance.ismasurance.policy.api.v1.dto.PolicyResponse;

public interface PolicyService {


    PolicyResponse createPolicy(PolicyRequest user);

    PolicyResponse getPolicyByName(PolicyRequest user);
}
