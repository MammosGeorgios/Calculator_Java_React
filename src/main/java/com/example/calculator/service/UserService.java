package com.example.calculator.service;

import com.example.calculator.db.entity.User;

public interface UserService {

    void insertUser();
    User getUserById(Long id);
}
