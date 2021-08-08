package com.example.bestbus.authentication;


import com.example.bestbus.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    private String home(){
        return "Welcome home";
    }

    @RequestMapping("/register")
//    private ResponseEntity<?> subscribeClient(@RequestBody RegistrationRequest registrationRequest){
    private ResponseEntity<?> subscribeClient(@RequestBody String string){
    	String[] arr=string.split(" ");
//        String username=registrationRequest.getUsername();
//        String password=registrationRequest.getPassword();
//        String email = registrationRequest.getEmail();
    	String username=arr[0];
        String password=arr[1];
        String email = arr[2];

        User user=new User(username,password,email);
        try {
            userRepository.save(user);
        }catch (Exception e){
            return ResponseEntity.ok(new AuthenticationResponse("Error occurred while Registration e: "+e));
        }

        return ResponseEntity.ok(new AuthenticationResponse("Successfully registered Client: "+username));

    }




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
