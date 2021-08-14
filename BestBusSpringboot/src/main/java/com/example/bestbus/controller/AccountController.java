package com.example.bestbus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
	

    @GetMapping("/home")
    private String home(){
        return "account/myhome";
    }
    
    
    
    
    
    

}
