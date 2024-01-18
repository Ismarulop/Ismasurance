package com.ismasurance.ismasurance.claim.repository;

import com.ismasurance.ismasurance.claim.api.v1.dto.SearchClaimRequest;
import com.ismasurance.ismasurance.claim.data.ClaimEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ClaimRepository extends MongoRepository<ClaimEntity,String> {
    List<ClaimEntity> getClaimByRequest(SearchClaimRequest searchClaimRequest);
}
