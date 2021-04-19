package com.example.calculator.web;

import com.example.calculator.model.OperationHistoryDTO;
import com.example.calculator.service.OperationService;
import com.example.calculator.service.impl.OperationServiceImpl;
import org.jboss.jandex.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FragmentController {


    private final OperationServiceImpl operationServiceImpl;

    @Autowired
    public FragmentController(OperationServiceImpl operationServiceImpl){
        this.operationServiceImpl=operationServiceImpl;
    }

    @GetMapping("/history")
    public String getHistory(@RequestParam(value = "id", required = true) Long id, Model model){
        List<OperationHistoryDTO> userHistory = operationServiceImpl.getUserHistory(id);
        model.addAttribute("userHistory",userHistory);
        return "fragments/history";
    }

}
