package com.example.bestbus.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bestbus.authentication.LoginRequest;
import com.example.bestbus.authentication.SignupRequest;
import com.example.bestbus.model.User;
import com.example.bestbus.model.UserRepository;


@Controller
@RequestMapping("/user")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    
    @GetMapping("/signup")
    private String viewSignup(Model model) {
    	SignupRequest signupRequest=new SignupRequest();
    	model.addAttribute("signupRequest", signupRequest);
    	return "signupView";
    }
    @PostMapping("/signup")
    private String processSignup(@ModelAttribute("user") SignupRequest signupRequest,Model model) {
    	
    	String username=signupRequest.getUsername();
        String password=signupRequest.getPassword();

        User user=new User(username,password);
        try {
            userRepository.save(user);
        }catch (Exception e){
        	return "signupView";
        }
    	return "loginView";
    }
    
    

//    @RequestMapping("/register")
//    private ResponseEntity<?> subscribeClient(@RequestBody RegistrationRequest registrationRequest){
//        String username=registrationRequest.getUsername();
//        String password=registrationRequest.getPassword();
//
//        User user=new User(username,password);
//        try {
//            userRepository.save(user);
//        }catch (Exception e){
//            return ResponseEntity.ok(new AuthenticationResponse("Error occurred while Registration e: "+e));
//        }
//
//        return ResponseEntity.ok(new AuthenticationResponse("Successfully registered Client: "+username));
//
//    }


    @GetMapping("/login")
    private String viewLogin(Model model) {
    	LoginRequest loginRequest=new LoginRequest();
    	model.addAttribute("loginRequest", loginRequest);
    	return "userLoginView";
    }
    @PostMapping("/login")
    private String processLogin(@ModelAttribute("user") LoginRequest loginRequest,Model model) {
    	String username=loginRequest.getUsername();
        String password =loginRequest.getPassword();
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (Exception e){
            return "loginView";
        }
    	return "homeView";
    }


//    @RequestMapping("/login")
//    private ResponseEntity<?> authenticateClient(@RequestBody LoginRequest loginRequest){
//        String username=loginRequest.getUsername();
//        String password =loginRequest.getPassword();
//        try{
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
//        }catch (Exception e){
//            return ResponseEntity.ok(new AuthenticationResponse("Failed to login Client exp: "+e));
//        }
//        return ResponseEntity.ok(new AuthenticationResponse("Successfully login Client: "+username));
//    }




}
