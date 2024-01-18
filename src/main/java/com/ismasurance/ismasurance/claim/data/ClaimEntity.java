package com.ismasurance.ismasurance.claim.data;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "Claims")
public class ClaimEntity {
    @Id
    @Field(name = "_id")
    private ObjectId id;
    @Field(name = "CLA_CLAIM")
    private String claClaim;
    @Field(name = "CLA_POLICY")
    private String claPolicy;
    @Field(name = "HANDLER_NAME")
    private String handlerName;
    @Field(name = "INSURED_NAME")
    private String insuredName;
    @Field(name = "TXT_CLAIM")
    private String txtClaim;
    @Field(name = "CLAIM_DATE")
    private Date claimDate;
    @Field(name = "INCIDENCE_DATE")
    private Date incidenceDate;
    @Field(name = "EXPIRATION_DATE")
    private Date expirationDate;

}
