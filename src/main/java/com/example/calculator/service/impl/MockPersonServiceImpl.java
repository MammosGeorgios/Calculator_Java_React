package com.example.calculator.service.impl;

import com.example.calculator.db.entity.MockPerson;
import com.example.calculator.db.entity.Role;
import com.example.calculator.db.entity.User;
import com.example.calculator.db.entity.UserInRole;
import com.example.calculator.db.repositories.MockPersonRepository;
import com.example.calculator.db.repositories.RoleRepository;
import com.example.calculator.db.repositories.UserInRoleRepository;
import com.example.calculator.db.repositories.UserRepository;
import com.example.calculator.service.MockPersonService;
import com.example.calculator.model.MockPersonDTO;
import com.example.calculator.utility.converter.MockPersonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockPersonServiceImpl implements MockPersonService {

    @Autowired
    MockPersonRepository mockPersonRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserInRoleRepository userInRoleRepository;

    @Autowired
    UserRepository userRepository;

    public List<String> getUserRoles(Long id){
        // User user = userRepository.getById(id);
        List<UserInRole> userInRoles = userInRoleRepository.findAllByUserId(id);
        List<String> roleNames = new ArrayList<>();

        for(var entry : userInRoles){
            roleNames.add(entry.getRole().getRoleName());
        }

        return roleNames;
    }

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

    @Override
    public List<MockPersonDTO> getAllWithTeams() {
        List<MockPerson> mockPeople = this.mockPersonRepository.findAll();
        List<MockPersonDTO> mockPeopleDTOList = MockPersonConverter.convertMockPersonEntityListToDTOWithTeam(mockPeople);
        return mockPeopleDTOList;
    }
}
