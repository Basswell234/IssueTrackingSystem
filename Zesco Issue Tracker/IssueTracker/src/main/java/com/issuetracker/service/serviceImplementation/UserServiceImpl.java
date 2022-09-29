package com.issuetracker.service.serviceImplementation;


import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.issuetracker.model.Role;
import com.issuetracker.model.User;
import com.issuetracker.repository.UserRepository;
import com.issuetracker.service.UserService;
import com.issuetracker.web.dto.UserRegistrationDto;


@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private UserRepository userRepo;

    private User user;
    
    public UserServiceImpl(UserRepository userRepo) {
        super();
        this.userRepo = userRepo;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) throws UsernameNotFoundException{
        //checking if user already exists in the database
        User user = userRepo.findByEmail(registrationDto.getEmail());
        if(user != null){
            throw new UsernameNotFoundException("username already exist");
        }
        //creating a new user and saving into the database
        user = new User(registrationDto.getFirstname(),
                    registrationDto.getLastname(),
                    registrationDto.getEmail(),
                    registrationDto.getRole(),
                    bCryptPasswordEncoder.encode(registrationDto.getPassword()) ,
                    Arrays.asList(new Role("ROLE_"))
                    );
       return userRepo.save(user);           
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    
}
