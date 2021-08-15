package com.example.bestbus.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SignupRequest {

	@NotEmpty(message = "E-mail Address Cannot be Empty")
	@Email(message = "E-mail Address is Not Correct")
    private String email;
	@NotEmpty(message = "Password Cannot be Empty")
	@Size(min = 4,max = 20)
    private String password; 
	@NotEmpty(message = "Re-type Password")
	private String rePassword;
	@NotEmpty(message = "First Name Cannot be Empty")
    private String firstName;
    private String lastName;
	
    
    
    
    public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
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
