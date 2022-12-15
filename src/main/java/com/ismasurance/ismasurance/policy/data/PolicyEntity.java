package com.ismasurance.ismasurance.policy.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "Policies")
public class PolicyEntity {
    @Id
    @Field(name = "_id")
    private String policyId;
    @Field(name = "CLN_POLICY")
    private String clnPolicy;
    @Field(name = "CLA_POLICY")
    private String claPolicy;
    @Field(name = "INSURANCE_NAME")
    private String insuranceName;
}
