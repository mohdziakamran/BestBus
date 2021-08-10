package com.example.bestbus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bestbus.authentication.LoginRequest;

@Controller
public class UserController {
	

    @GetMapping("/home")
    private String home(){
    	
    	
//    	System.out.println("welcome home");
        return "home";
    }
    
//    @GetMapping("/")
//    private String test() {
////    	System.out.println("welcome index");
//    	return "index";
//    }
    
    @GetMapping("/")
    private String testloginview(Model model) {
    	LoginRequest loginRequest=new LoginRequest();
    	model.addAttribute("loginRequest", loginRequest);
    	
    	return "userlogin";
    }
    @PostMapping("/")
    private String testloginprocess(@ModelAttribute("user") LoginRequest loginRequest,Model model) {
    	System.out.println(loginRequest);////////////////
    	return "index";
    }

}
