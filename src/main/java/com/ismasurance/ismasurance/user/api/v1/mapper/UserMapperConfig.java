package com.ismasurance.ismasurance.user.api.v1.mapper;

import com.ismasurance.ismasurance.user.api.v1.dto.UserRequest;
import com.ismasurance.ismasurance.user.api.v1.dto.UserResponse;
import com.ismasurance.ismasurance.user.data.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserMapperConfig {
    @Bean
    public UserMapper userMapper() {
        return new UserMapper() {
            @Override
            public UserEntity userRequestToUserEntity(UserRequest userRequest) {
                UserEntity user = new UserEntity();
                user.setUserName(userRequest.getUserName());
                user.setEmail(userRequest.getEmail());
                user.setPhone(userRequest.getPhone());
                user.setCountry(userRequest.getCountry());

                return user;
            }

            @Override
            public UserResponse userEntityToUserResponse(UserEntity userEntity) {
                UserResponse user = new UserResponse();
                user.setId(userEntity.getId());
                user.setUserId(userEntity.getUserId());
                user.setUserName(userEntity.getUserName());
                user.setEmail(userEntity.getEmail());
                user.setPhone(userEntity.getPhone());
                user.setCountry(userEntity.getCountry());

                return user;
            }
        };
    }
}
