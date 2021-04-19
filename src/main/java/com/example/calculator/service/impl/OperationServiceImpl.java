package com.example.calculator.service.impl;

import com.example.calculator.db.entity.Operation;
import com.example.calculator.db.entity.User;
import com.example.calculator.db.repositories.OperationRepository;
import com.example.calculator.db.repositories.UserRepository;
import com.example.calculator.model.OperationHistoryDTO;
import com.example.calculator.service.OperationService;
import com.example.calculator.utility.math.OperatorMathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    UserRepository userRepository;

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

    @Override
    public List<OperationHistoryDTO> getUserHistory(Long id) {
        List<Operation> userOperationsHistory = operationRepository.getAllByUser(userRepository.getById(id));
        List<OperationHistoryDTO> userOperationsHistoryDTO = new ArrayList<>();

        for(Operation entry:userOperationsHistory){
            OperationHistoryDTO tempDTO = new OperationHistoryDTO(entry.getOperationString(), entry.getResult());
            userOperationsHistoryDTO.add(tempDTO);
        }
        return(userOperationsHistoryDTO);

    }

    public String convertToForwardSlashesFromUnderscore (String expression){
        return expression.replace("_","/");
    }

}
