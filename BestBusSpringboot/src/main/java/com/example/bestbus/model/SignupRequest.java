package com.example.bestbus.model;

import javax.validation.constraints.NotEmpty;

public class SignupRequest {

	@NotEmpty(message = "fill email")
    private String email;
	@NotEmpty(message = "password cannot be empty")
    private String password;
	@NotEmpty(message = "fill First name")
    private String firstName;
	@NotEmpty(message = "fill Last name")
    private String lastName;
	
    
    
    
    public SignupRequest() {
	}
	public SignupRequest(String email, String password, String firstName, String lastName) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

    
    

}
