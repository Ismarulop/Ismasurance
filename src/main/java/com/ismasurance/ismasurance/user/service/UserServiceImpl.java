package com.ismasurance.ismasurance.user.service;

import com.ismasurance.ismasurance.user.api.v1.dto.UserRequest;
import com.ismasurance.ismasurance.user.api.v1.dto.UserResponse;
import com.ismasurance.ismasurance.user.api.v1.dto.UserSignInRequest;
import com.ismasurance.ismasurance.user.api.v1.mapper.UserMapper;
import com.ismasurance.ismasurance.user.data.UserEntity;


import com.ismasurance.ismasurance.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper mapper;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        UserEntity userEntity = mapper.userRequestToUserEntity(userRequest);
        UserEntity user = userRepository.findByEmail(userEntity.getEmail());
        if (null == user) {
            userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));
            userEntity.setUserId(UUID.randomUUID().toString());
            userRepository.save(userEntity);
        } else {
            throw new RuntimeException("Ya existe el usuario");
        }

        return mapper.userEntityToUserResponse(userEntity);
    }

    @Override
    public UserResponse getUser(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);

        if (userEntity == null) {
            throw new UsernameNotFoundException(email);
        }
        return mapper.userEntityToUserResponse(userEntity);

    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<UserResponse> response = new ArrayList<>();
        Iterable<UserEntity> usersList = userRepository.findAll();
        for (UserEntity user : usersList) {
            UserResponse userResponse = mapper.userEntityToUserResponse(user);
            response.add(userResponse);
        }
        return response;
    }

    @Override
    public UserDetails signInValidation(UserSignInRequest userSignInRequest) {
        UserEntity userEntity = userRepository.findByEmail(userSignInRequest.getEmail());
        if (null != userEntity) {
            return new User(userEntity.getUserName(), userEntity.getEncryptedPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException(userSignInRequest.getEmail());
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);

        if (userEntity == null) {
            throw new UsernameNotFoundException(email);
        }

        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }

}
