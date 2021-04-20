package com.example.calculator.web;

import com.example.calculator.security.MyUserPrincipal;
import com.example.calculator.service.impl.OperationServiceImpl;
import com.example.calculator.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calculator")
public class CalculatorWebController {

    @Autowired
    private OperationServiceImpl operationServiceImpl;

    @Autowired
    private UserServiceImpl userServiceImpl;



    @GetMapping
    public String getCalculator(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof MyUserPrincipal) {
            String name = ((MyUserPrincipal)principal).getName();
            model.addAttribute("username", name);
        }else{
            model.addAttribute("username", "Name");
        }
        return "calculator";
    }
}
