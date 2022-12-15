package com.ismasurance.ismasurance.policy.api.v1.mapper;

import com.ismasurance.ismasurance.claim.api.v1.mapper.ClaimMapper;
import com.ismasurance.ismasurance.policy.api.v1.dto.PolicyRequest;
import com.ismasurance.ismasurance.policy.api.v1.dto.PolicyResponse;
import com.ismasurance.ismasurance.policy.data.PolicyEntity;
import com.ismasurance.ismasurance.policy.api.v1.mapper.PolicyMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PolicyMapperConfig {

    @Bean
    public PolicyMapper policyMapper() {
        return new PolicyMapper() {

            @Override
            public PolicyEntity policyRequestToPolicyEntity(PolicyRequest request) {
                PolicyEntity policyEntity = new PolicyEntity();
                policyEntity.setInsuranceName(request.getInsuranceName());

                return policyEntity;
            }

            @Override
            public PolicyResponse policyEntityToPolicyResponse(PolicyEntity entity) {
                PolicyResponse policyResponse = new PolicyResponse();
                policyResponse.setPolicyId(entity.getPolicyId());
                policyResponse.setInsuranceName(entity.getInsuranceName());
                return policyResponse;
            }
        };
    }
}
