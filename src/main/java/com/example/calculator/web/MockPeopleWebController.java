package com.example.calculator.web;

import com.example.calculator.db.entity.MockPerson;
import com.example.calculator.service.impl.MockPersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/mockpeople")
public class MockPeopleWebController {

    private final MockPersonServiceImpl mockPersonServiceImpl;

    @Autowired
    public MockPeopleWebController(MockPersonServiceImpl mockPersonServiceImpl) {
        this.mockPersonServiceImpl = mockPersonServiceImpl;
    }

    @GetMapping
    public String getMockPeople(Model model){
        List<MockPerson> mockPeople = this.mockPersonServiceImpl.getAll();
        model.addAttribute("mockPeople",mockPeople);
        return "mockpeople";
    }

}
