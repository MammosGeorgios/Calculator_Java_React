package com.example.calculator.service;

import com.example.calculator.db.entity.MockPerson;

import java.util.List;

public interface MockPersonService {

    List<MockPerson> getAll();
    List<MockPerson> getByAge(Long age);
}
