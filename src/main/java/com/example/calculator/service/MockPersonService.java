package com.example.calculator.service;

import com.example.calculator.db.entity.MockPerson;
import com.example.calculator.temp.MockPersonView;

import java.util.List;

public interface MockPersonService {

    List<MockPerson> getAll();
    List<MockPerson> getByAge(Long age);
    void addNewMockPerson(MockPersonView mockPersonView);
}
