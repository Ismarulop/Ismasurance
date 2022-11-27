package com.ismasurance.ismasurance.user.service;

import com.ismasurance.ismasurance.user.model.UserEntity;
import com.ismasurance.ismasurance.user.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public String createUser(UserEntity user) {
        userRepository.save(user);
        return "Creado user: " + user.getUsername();
    }
}
