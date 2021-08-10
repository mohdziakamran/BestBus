package com.example.bestbus.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bestbus.authentication.AuthenticationResponse;
import com.example.bestbus.authentication.LoginRequest;
import com.example.bestbus.authentication.RegistrationRequest;
import com.example.bestbus.model.User;
import com.example.bestbus.model.UserRepository;


@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    
    

    @RequestMapping("/register")
    private ResponseEntity<?> subscribeClient(@RequestBody RegistrationRequest registrationRequest){
        String username=registrationRequest.getUsername();
        String password=registrationRequest.getPassword();

        User user=new User(username,password);
        try {
            userRepository.save(user);
        }catch (Exception e){
            return ResponseEntity.ok(new AuthenticationResponse("Error occurred while Registration e: "+e));
        }

        return ResponseEntity.ok(new AuthenticationResponse("Successfully registered Client: "+username));

    }



//    private String loginview

    @RequestMapping("/login")
    private ResponseEntity<?> authenticateClient(@RequestBody LoginRequest loginRequest){
        String username=loginRequest.getUsername();
        String password =loginRequest.getPassword();
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (Exception e){
            return ResponseEntity.ok(new AuthenticationResponse("Failed to login Client exp: "+e));
        }
        return ResponseEntity.ok(new AuthenticationResponse("Successfully login Client: "+username));
    }




}
