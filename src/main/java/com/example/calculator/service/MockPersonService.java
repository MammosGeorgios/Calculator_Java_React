package com.example.calculator.service;


import com.example.calculator.model.MockPersonDTO;

import java.util.List;

public interface MockPersonService {

    List<MockPersonDTO> getAll();
    List<MockPersonDTO> getByAge(Long age);
    void addNewMockPerson(MockPersonDTO mockPersonDTO);
    void addNonDuplicateMockPerson(MockPersonDTO mockPersonDTO);
}
