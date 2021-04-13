package com.example.calculator.service;

import com.example.calculator.db.entity.MockPerson;
import com.example.calculator.model.MockPersonDTO;

import java.util.List;

public interface MockPersonService {

    List<MockPerson> getAll();
    List<MockPerson> getByAge(Long age);
    void addNewMockPerson(MockPersonDTO mockPersonDTO);
    void addNonDuplicateMockPerson(MockPersonDTO mockPersonDTO);
}
