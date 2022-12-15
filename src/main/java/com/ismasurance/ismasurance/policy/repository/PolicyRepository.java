package com.ismasurance.ismasurance.policy.repository;

import com.ismasurance.ismasurance.policy.data.PolicyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends MongoRepository<PolicyEntity,String> {
    PolicyEntity findByInsuranceName(String insuranceName);
}
