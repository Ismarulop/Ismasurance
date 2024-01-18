package com.ismasurance.ismasurance.user.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;

@Data
@Document(collection = "Users")
public class UserEntity {

    @Id
    @Field(name = "_id")
    private BigInteger id;

    @Field(name = "userId")
    private String userId;

    @Field(name = "USER_NAME")
    private String userName;

    @Field(name = "ENCRYPTED_PASSWORD")
    private String encryptedPassword;

    @Field(name = "EMAIL")
    private String email;

    @Field(name = "PHONE")
    private String phone;

    @Field(name = "COUNTRY_CODE")
    private String countryCode;

    @Field(name = "COUNTRY")
    private String country;


}
