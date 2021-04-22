package com.example.calculator.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;



public class UserDTO {
    @NotNull
    @NotEmpty(message = "Username must not be empty")
    private String username;

    @NotNull
    @NotEmpty(message = "Password must not be empty")
    @Length(min=6, message="Password must be at least 6 characters")
    private String password;
    private String matchingPassword;

    @NotNull
    @NotEmpty(message = "Your name must not be empty")
    private String name;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
