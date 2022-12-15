package com.ismasurance.ismasurance.user.api.v1.mapper;

import com.ismasurance.ismasurance.user.api.v1.dto.UserRequest;
import com.ismasurance.ismasurance.user.api.v1.dto.UserResponse;
import com.ismasurance.ismasurance.user.data.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper
public interface UserMapper {

    @Named("UserRequestToUserEntity")
    UserEntity userRequestToUserEntity(UserRequest userRequest);

    @Named("UserEntityToUserResponse")
    UserResponse userEntityToUserResponse(UserEntity userEntity);

}
