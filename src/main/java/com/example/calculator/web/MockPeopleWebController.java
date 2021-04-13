package com.example.calculator.web;

import com.example.calculator.db.entity.MockPerson;
import com.example.calculator.service.impl.MockPersonServiceImpl;
import com.example.calculator.model.MockPersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mockpeople")
public class MockPeopleWebController {

    private final MockPersonServiceImpl mockPersonServiceImpl;

    @Autowired
    public MockPeopleWebController(MockPersonServiceImpl mockPersonServiceImpl) {
        this.mockPersonServiceImpl = mockPersonServiceImpl;
    }

//    @GetMapping
//    public String getMockPeople(Model model){
//        List<MockPerson> mockPeople = this.mockPersonServiceImpl.getAll();
//        model.addAttribute("mockPeople",mockPeople);
//        return "mockpeople";
//    }

    @GetMapping
    public String getMockPeople(@RequestParam(value="age",required=false) Long age, Model model){
        List<MockPerson> mockPeople= null;
        if(age==null){
            mockPeople = this.mockPersonServiceImpl.getAll();
        }else{
            mockPeople = this.mockPersonServiceImpl.getByAge(age);
        }

        // if no result to show i return nothing. This allows me ot check for null with thymeleaf and make the view accordingly
        if(!mockPeople.isEmpty()){
            model.addAttribute("mockPeople",mockPeople);
        }

        // adding the form model
        model.addAttribute("mockPersonDTO", new MockPersonDTO());
        return "mockpeople";
    }


    @PostMapping
    public String postMockPeople(@ModelAttribute MockPersonDTO mockPersonDTO, Model model){
        this.mockPersonServiceImpl.addNewMockPerson(mockPersonDTO);
        String message = "New Person Added is: Name: " + mockPersonDTO.getName() + " , Age: "+ mockPersonDTO.getAge();
        model.addAttribute("newPersonMessage", message);
        return "mockpeople";
    }

}
