package com.codelean.controller;

import com.codelean.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("/")
public class UserController {
    @GetMapping("/user-validate")
    public String showForm(Model model){
        model.addAttribute("user", new User());
        return "uservalidate";
    }

    @PostMapping("/user-validate")
    public String checkValidation (@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "uservalidate";
        }
        return "result";
    }

}
