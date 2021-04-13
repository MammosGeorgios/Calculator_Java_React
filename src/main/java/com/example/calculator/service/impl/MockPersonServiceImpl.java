package com.example.calculator.service.impl;

import com.example.calculator.db.entity.MockPerson;
import com.example.calculator.db.repositories.MockPersonRepository;
import com.example.calculator.service.MockPersonService;
import com.example.calculator.model.MockPersonDTO;
import com.example.calculator.utility.converter.MockPersonConverter;
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
    public List<MockPersonDTO> getAll() {
        List<MockPerson> mockPeople = this.mockPersonRepository.findAll();
        List<MockPersonDTO> mockPeopleDTOList = MockPersonConverter.convertMockPersonEntityListToDTOWithId(mockPeople);
        return mockPeopleDTOList;
    }

    @Override
    public List<MockPersonDTO> getByAge(Long age) {
        List<MockPerson> mockPeople = this.mockPersonRepository.getAllByAge(age);
        List<MockPersonDTO> mockPeopleDTOList = MockPersonConverter.convertMockPersonEntityListToDTOWithId(mockPeople);
        return mockPeopleDTOList;
    }

    @Override
    public void addNewMockPerson(MockPersonDTO mockPersonDTO) {
       // this.mockPersonRepository.save(new MockPerson(mockPersonDTO.getName(), mockPersonDTO.getAge()));
        this.mockPersonRepository.save(MockPersonConverter.convertMockPersonDTOtoEntityWithoutId(mockPersonDTO));
    }

    @Override
    public void addNonDuplicateMockPerson(MockPersonDTO mockPersonDTO) {
        // CHECK IF IT'S A DUPLICATE OR NOT
    }
}
