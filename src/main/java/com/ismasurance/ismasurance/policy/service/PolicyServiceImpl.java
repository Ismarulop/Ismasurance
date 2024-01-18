package com.ismasurance.ismasurance.policy.service;

import com.ismasurance.ismasurance.exception.dto.RequestException;
import com.ismasurance.ismasurance.policy.api.v1.dto.PolicyRequest;
import com.ismasurance.ismasurance.policy.api.v1.dto.PolicyResponse;
import com.ismasurance.ismasurance.policy.data.PolicyEntity;
import com.ismasurance.ismasurance.policy.api.v1.mapper.PolicyMapper;
import com.ismasurance.ismasurance.policy.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PolicyServiceImpl implements PolicyService {
    @Autowired
    PolicyRepository policyRepository;

    @Autowired
    PolicyMapper policyMapper;

    public PolicyResponse createPolicy(PolicyRequest request) {
        PolicyEntity entity = policyMapper.policyRequestToPolicyEntity(request);
        if ("".equals(request.getInsuranceName()) || null == request.getInsuranceName()) {
            throw new RequestException("Bad request",  HttpStatus.BAD_REQUEST);
        }
        policyRepository.save(entity);
        return policyMapper.policyEntityToPolicyResponse(entity);
    }

    @Override
    public PolicyResponse getPolicyByName(PolicyRequest request) {
        PolicyEntity entity = policyRepository.findByInsuranceName(request.getInsuranceName());
        if (null != entity) {
            return policyMapper.policyEntityToPolicyResponse(entity);
        } else {
            return new PolicyResponse();
        }
    }
}
