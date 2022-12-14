package com.issuetracker.web.dto;

public class UserRegistrationDto {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String role;

    //constructor
    public UserRegistrationDto(String firstname, String lastname, String email, String password,String role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    
    public UserRegistrationDto() {
    }

    //getter and setters
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
