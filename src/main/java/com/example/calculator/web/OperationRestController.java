package com.example.calculator.web;

import com.example.calculator.db.entity.Operation;
import com.example.calculator.service.OperationService;
import com.example.calculator.service.impl.OperationServiceImpl;
import com.example.calculator.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class OperationRestController {

    @Autowired
    private OperationServiceImpl operationServiceImpl;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/operation/'{string}'")
    public String read(@PathVariable String string){
        String testString ="1 + 2 + 3";
        operationServiceImpl.saveResult(testString, userServiceImpl.getUserById(1L));
            return operationServiceImpl.getResult(testString);
    }
    @GetMapping("/operation/test")
    public String read(){
        String testString ="1 + 2 + 3";
        operationServiceImpl.saveResult(testString, userServiceImpl.getUserById(1L));
        return ("Executing Operation "+ testString +". Result is: " + operationServiceImpl.getResult(testString));
    }


}
