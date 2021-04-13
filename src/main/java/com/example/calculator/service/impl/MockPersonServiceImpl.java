package com.example.calculator.service.impl;

import com.example.calculator.db.entity.MockPerson;
import com.example.calculator.db.repositories.MockPersonRepository;
import com.example.calculator.service.MockPersonService;
import com.example.calculator.model.MockPersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockPersonServiceImpl implements MockPersonService {

    @Autowired
    MockPersonRepository mockPersonRepository;

//    @Autowired
//    public MockPersonServiceImpl(MockPersonRepository mockPersonRepository) {
//        this.mockPersonRepository = mockPersonRepository;
//    }

    @Override
    public List<MockPerson> getAll() {
        List<MockPerson> mockPeople = this.mockPersonRepository.findAll();
        return mockPeople;
    }

    @Override
    public List<MockPerson> getByAge(Long age) {
        List<MockPerson> mockPeople = this.mockPersonRepository.getAllByAge(age);
        return mockPeople;
    }

    // This should probably change to have the normal model as argument
    @Override
    public void addNewMockPerson(MockPersonDTO mockPersonDTO) {
        this.mockPersonRepository.save(new MockPerson(mockPersonDTO.getName(), mockPersonDTO.getAge()));
    }

    @Override
    public void addNonDuplicateMockPerson(MockPersonDTO mockPersonDTO) {
        // CHECK IF IT'S A DUPLICATE OR NOT
    }
}
