package com.example.calculator.service;

import com.example.calculator.db.entity.User;
import com.example.calculator.model.OperationHistoryDTO;

import java.util.List;

public interface OperationService {
    String getResult(String formula);
    void saveResult(String formula, User user);
    void saveResult(String formula, String result,User user);
    List<OperationHistoryDTO> getUserHistory(Long id);
}
