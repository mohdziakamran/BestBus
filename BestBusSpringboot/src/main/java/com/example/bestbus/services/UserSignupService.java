package com.example.bestbus.services;

import com.example.bestbus.exceptions.UserAlreadyExistException;
import com.example.bestbus.model.SignupRequest;
import com.example.bestbus.model.User;

public interface UserSignupService {

	public void register(final SignupRequest signupRequest) throws UserAlreadyExistException;
    public boolean checkIfUserExist(String email);
    public void encodePassword(SignupRequest signupRequest,User user);
}
