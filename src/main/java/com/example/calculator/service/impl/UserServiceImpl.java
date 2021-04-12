package com.example.calculator.service.impl;

import com.example.calculator.db.repositories.UserRepository;
import com.example.calculator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void insertUser() {

    }
}
