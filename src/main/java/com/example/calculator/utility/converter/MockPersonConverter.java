package com.example.calculator.utility.converter;

import com.example.calculator.db.entity.MockPerson;
import com.example.calculator.model.MockPersonDTO;

import java.util.ArrayList;
import java.util.List;

public class MockPersonConverter {

    public static MockPerson convertMockPersonDTOtoEntityWithoutId(MockPersonDTO mockPersonDTO){
        MockPerson mockPerson= new MockPerson(mockPersonDTO.getName(), mockPersonDTO.getAge());
        return mockPerson;
    }

    public static MockPerson convertMockPersonDTOtoEntityWithId(MockPersonDTO mockPersonDTO){
        MockPerson mockPerson= new MockPerson(mockPersonDTO.getId() ,mockPersonDTO.getName(), mockPersonDTO.getAge());
        return mockPerson;
    }

    public static MockPersonDTO convertMockPersonEntityToDTOWithoutId(MockPerson mockPerson){
        MockPersonDTO mockPersonDTO= new MockPersonDTO(mockPerson.getName(), mockPerson.getAge());
        return mockPersonDTO;
    }

    public static MockPersonDTO convertMockPersonEntityToDTOWithId(MockPerson mockPerson){
        MockPersonDTO mockPersonDTO= new MockPersonDTO(mockPerson.getId() ,mockPerson.getName(), mockPerson.getAge());
        return mockPersonDTO;
    }

    public static List<MockPersonDTO> convertMockPersonEntityListToDTOWithId(List<MockPerson> MockPersonList){
        List<MockPersonDTO> mockPersonDTOList = new ArrayList<>();
        for(MockPerson mockPerson:MockPersonList){
            MockPersonDTO mockPersonDTO = MockPersonConverter.convertMockPersonEntityToDTOWithId(mockPerson);
            mockPersonDTOList.add(mockPersonDTO);
        }
        return(mockPersonDTOList);
    }

    public static List<MockPersonDTO> convertMockPersonEntityListToDTOWithoutId(List<MockPerson> MockPersonList){
        List<MockPersonDTO> mockPersonDTOList = new ArrayList<>();
        for(MockPerson mockPerson:MockPersonList){
            MockPersonDTO mockPersonDTO = MockPersonConverter.convertMockPersonEntityToDTOWithoutId(mockPerson);
            mockPersonDTOList.add(mockPersonDTO);
        }
        return(mockPersonDTOList);
    }


    // ADDED LATER FOR TESTING THE FOREIGN KEY FUNCTIONALITY
    public static MockPersonDTO convertMockPersonEntityToDTOWithTeam(MockPerson mockPerson){
        MockPersonDTO mockPersonDTO= new MockPersonDTO(mockPerson.getId() ,mockPerson.getName(), mockPerson.getAge(), mockPerson.getMockTeam().getName());
        return mockPersonDTO;
    }

    public static List<MockPersonDTO> convertMockPersonEntityListToDTOWithTeam(List<MockPerson> MockPersonList) {

        List<MockPersonDTO> mockPersonDTOList = new ArrayList<>();
        for(MockPerson mockPerson:MockPersonList){
            MockPersonDTO mockPersonDTO = MockPersonConverter.convertMockPersonEntityToDTOWithTeam(mockPerson);
            mockPersonDTOList.add(mockPersonDTO);
        }
        return(mockPersonDTOList);
    }

}

