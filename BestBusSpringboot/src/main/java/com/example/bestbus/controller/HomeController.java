package com.example.bestbus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    
    @GetMapping("/notDone")
    private String notDone() {
    	return "Sorry not implemented yet";
    }
    
    
    

}
