package com.example.bestbus.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class LoginRequest {
	
	@NotEmpty(message = "E-mail Address Cannot be Empty")
	@Email(message = "E-mail Address is Not Correct")
	String username;
	@NotEmpty(message = "Password Cannot be Empty")
    String password;

    public LoginRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	@Override
	public String toString() {
		return "LoginRequest [username=" + username + ", password=" + password + "]";
	}
    
}
