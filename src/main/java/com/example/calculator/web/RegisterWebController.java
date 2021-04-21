package com.example.calculator.web;

import com.example.calculator.model.MockPersonDTO;
import com.example.calculator.model.UserDTO;
import com.example.calculator.service.impl.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterWebController {


    private final RegisterServiceImpl registerService;

    @Autowired
    public RegisterWebController(RegisterServiceImpl registerService) {
        this.registerService = registerService;
    }

    @GetMapping()
    public String getRegister(WebRequest request , Model model){
        model.addAttribute("userDTO",new UserDTO());
        return "register";
    }

    @PostMapping()
    public String postRegister(@ModelAttribute @Valid UserDTO userDTO, Model model, Errors errors){
        this.registerService.newUser(userDTO);

        model.addAttribute("message","it worked");
        return ("register" );
    }



}
