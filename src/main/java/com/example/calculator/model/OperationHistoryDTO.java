package com.example.calculator.model;

import com.example.calculator.db.entity.Operation;

public class OperationHistoryDTO {

    private String operationString;
    private String result;

    public String getOperationString() {
        return operationString;
    }

    public void setOperationString(String operationString) {
        this.operationString = operationString;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public OperationHistoryDTO(){};
    public OperationHistoryDTO(String operationString, String result){
        this.operationString=operationString;
        this.result=result;
    }

    public static OperationHistoryDTO convertToDTO(Operation operation){
        OperationHistoryDTO operationDTO = new OperationHistoryDTO(operation.getOperationString(), operation.getResult());
        return operationDTO;
    }
}
