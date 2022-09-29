package com.issuetracker.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.issuetracker.model.User;
import com.issuetracker.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{

    User save(UserRegistrationDto registrationDto);

    
}
