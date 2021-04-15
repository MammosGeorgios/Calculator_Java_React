package com.example.calculator.service.impl;

import com.example.calculator.db.entity.Operation;
import com.example.calculator.db.entity.User;
import com.example.calculator.db.repositories.OperationRepository;
import com.example.calculator.service.OperationService;
import com.example.calculator.utility.math.OperatorMathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    OperationRepository operationRepository;

    @Override
    public String getResult(String formula) {
        return OperatorMathUtils.calculateResult(formula);
    }

    @Override
    public void saveResult(String formula, User user) {
        String result =  OperatorMathUtils.calculateResult(formula);
        this.operationRepository.save(new Operation(formula, result, user));
    }

    @Override
    public void saveResult(String formula, String result, User user) {
        this.operationRepository.save(new Operation(formula, result, user));
    }

}
