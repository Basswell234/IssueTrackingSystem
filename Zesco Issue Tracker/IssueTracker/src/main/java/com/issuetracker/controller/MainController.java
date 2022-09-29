package com.issuetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.issuetracker.model.User;
import com.issuetracker.repository.UserRepository;

@Controller
public class MainController {

	@Autowired
    UserRepository repo;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

	//getting all user in the database
	@GetMapping("/dashboard")
	public String viewDashboard(Model model){
		List<User> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}
}
