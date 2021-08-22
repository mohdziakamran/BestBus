package com.example.bestbus.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bestbus.model.LoginRequest;


@Controller
@RequestMapping("/login")
public class LoginController {

//    @Autowired
//    private AuthenticationManager authenticationManager;

//	@Autowired
//	private AuthenticationProvider authenticationProvider;


    @GetMapping
    private String viewLogin(@RequestParam(value = "invalid-session", defaultValue = "false") boolean invalidSession,
    							Model model) {
    	
    	if(invalidSession) {
    		model.addAttribute("invalidSession", "Invalid session");
//    		System.out.println("-----------------");
    	}
    	
    	LoginRequest loginRequest=new LoginRequest();
    	model.addAttribute("loginRequest", loginRequest);
    	return "loginView";
    }
    
    
    
//    @PostMapping("/login")
//    private String processLogin(@ModelAttribute("user") LoginRequest loginRequest,Model model) {
//    	String username=loginRequest.getUsername();
//        String password =loginRequest.getPassword();
//        System.out.println(loginRequest.toString());/////////////////
//        model.addAttribute("loginRequest", new LoginRequest());
//        try{
//        	authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(username,password));
////            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
//        }catch (Exception e){
//        	System.out.println("login error: "+e);//////////
//        	return "loginView";
//        }
//        System.out.println("login Sucesssfull");//////////
//    	return "redirect:account/homesweethome";
//    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
