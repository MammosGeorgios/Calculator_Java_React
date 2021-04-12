package com.example.calculator.service.impl;

import com.example.calculator.db.entity.MockPerson;
import com.example.calculator.db.repositories.MockPersonRepository;
import com.example.calculator.service.MockPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockPersonServiceImpl implements MockPersonService {

    @Autowired
    MockPersonRepository mockPersonRepository;

    @Autowired
    public MockPersonServiceImpl(MockPersonRepository mockPersonRepository) {
        this.mockPersonRepository = mockPersonRepository;
    }

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
}
