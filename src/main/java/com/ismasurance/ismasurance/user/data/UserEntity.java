package com.ismasurance.ismasurance.user.data;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Data
@Getter
@Document(collection = "Users")
public class UserEntity {

    @Id
    @Field(name = "_id")
    private String userId;
    @Field(name = "USER_NAME")
    private String userName;
    @Field(name = "PASSWORD")
    private String password;
    @Field(name = "EMAIL")
    private String email;
    @Field(name = "PHONE")
    private String phone;
    @Field(name = "COUNTRY_CODE")
    private String countryCode;
    @Field(name = "COUNTRY")
    private String country;

}
