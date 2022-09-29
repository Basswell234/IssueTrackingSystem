package com.issuetracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.issuetracker.service.UserService;
import com.issuetracker.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("registration")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping
    public String registrationForm(Model model){
        model.addAttribute("user", new UserRegistrationDto());
        return "registration";
    }
    
    //saveing a new user to the database 
    @PostMapping
    public String registerAccount(@ModelAttribute("user") UserRegistrationDto registrationDto){
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }
    
}
