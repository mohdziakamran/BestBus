package com.example.bestbus.controller;


import java.lang.ProcessBuilder.Redirect;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bestbus.exceptions.UserAlreadyExistException;
import com.example.bestbus.model.LoginRequest;
import com.example.bestbus.model.SignupRequest;
import com.example.bestbus.model.User;
import com.example.bestbus.repository.UserRepository;
import com.example.bestbus.services.UserService;


@Controller
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    private UserService userService;
    
    @GetMapping
    private String viewSignup(final Model model) {
    	model.addAttribute("signupRequest", new SignupRequest());
    	return "signupView";
    }
    
    
    @PostMapping
    private String processSignup(final @Valid SignupRequest signupRequest,final BindingResult bindingResult,final Model model) {
    	
    	if(bindingResult.hasErrors()) {
    		model.addAttribute("signupRequest",signupRequest);
    		return "signupView";
    	}
        
        try {
        	userService.register(signupRequest);
        }catch (UserAlreadyExistException e){
        	System.out.println("exception");///////////
        	bindingResult.rejectValue("email", "signupRequest.email", "Account already exist with this email address");
        	model.addAttribute("signupRequest",signupRequest);
    		return "signupView";
        }
        System.out.println("sucessfully signup");
        System.out.println(signupRequest.toString());
        return "redirect:account/home";
    }
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//  @RequestMapping("/register")
//  private ResponseEntity<?> subscribeClient(@RequestBody RegistrationRequest registrationRequest){
//      String username=registrationRequest.getUsername();
//      String password=registrationRequest.getPassword();
//
//      User user=new User(username,password);
//      try {
//          userRepository.save(user);
//      }catch (Exception e){
//          return ResponseEntity.ok(new AuthenticationResponse("Error occurred while Registration e: "+e));
//      }
//
//      return ResponseEntity.ok(new AuthenticationResponse("Successfully registered Client: "+username));
//
//  }

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
