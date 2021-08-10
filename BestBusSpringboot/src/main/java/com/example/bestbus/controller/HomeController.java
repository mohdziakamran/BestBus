package com.example.bestbus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bestbus.authentication.LoginRequest;

@Controller
public class HomeController {
	

    @GetMapping("/home")
    private String home(){
        return "homeView";
    }
    
    @GetMapping("/")
    private String index() {
    	return "index";
    }
    

}
