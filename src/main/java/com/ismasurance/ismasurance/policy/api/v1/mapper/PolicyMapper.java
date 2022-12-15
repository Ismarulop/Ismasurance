package com.ismasurance.ismasurance.policy.api.v1.mapper;

import com.ismasurance.ismasurance.policy.api.v1.dto.PolicyRequest;
import com.ismasurance.ismasurance.policy.api.v1.dto.PolicyResponse;
import com.ismasurance.ismasurance.policy.data.PolicyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper
public interface PolicyMapper {

    @Named("PolicyRequestToPolicyEntity")
    PolicyEntity policyRequestToPolicyEntity(PolicyRequest request);

    @Named("PolicyEntityToPolicyResponse")
    PolicyResponse policyEntityToPolicyResponse(PolicyEntity enitity);
}
