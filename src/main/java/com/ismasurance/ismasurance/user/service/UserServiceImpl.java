package com.ismasurance.ismasurance.user.service;

import com.ismasurance.ismasurance.user.api.v1.dto.UserRequest;
import com.ismasurance.ismasurance.user.api.v1.dto.UserResponse;
import com.ismasurance.ismasurance.user.api.v1.dto.UserSignInRequest;
import com.ismasurance.ismasurance.user.api.v1.mapper.UserMapper;
import com.ismasurance.ismasurance.user.data.UserEntity;
import com.ismasurance.ismasurance.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper mapper;
    @Override
    public UserResponse createUser(UserRequest userRequest) {
        UserEntity userEntity= mapper.userRequestToUserEntity(userRequest);
        UserEntity user=userRepository.findUserByUserName(userEntity.getUserName());
        if(null ==user){
            userRepository.save(userEntity);
        }else{
            throw new RuntimeException("Ya existe el usuario");
        }

        return mapper.userEntityToUserResponse(userEntity);
    }

    @Override
    public UserResponse signInValidation(UserRequest user)  {
        UserEntity userEntity= userRepository.findUserByUserName(user.getUserName());
        if(null!=userEntity && userEntity.getPassword().equals(user.getPassword())){
            UserResponse returnedUser= mapper.userEntityToUserResponse(userEntity);
            return returnedUser;
        }else{
            return new UserResponse();
        }
    }
}
