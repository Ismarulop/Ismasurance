package com.ismasurance.ismasurance.claim.repository;

import com.ismasurance.ismasurance.claim.data.ClaimEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClaimRepository extends MongoRepository<ClaimEntity,String> {
}
