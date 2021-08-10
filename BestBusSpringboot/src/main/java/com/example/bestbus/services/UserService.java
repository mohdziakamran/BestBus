package com.example.bestbus.services;

import com.example.bestbus.model.User;
import com.example.bestbus.model.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundedUser =userRepository.findByUsername(username);
        if(foundedUser==null) {
        	return null;
        }
        String name=foundedUser.getUsername();
        String pwd=foundedUser.getPassword();

        return new org.springframework.security.core.userdetails.User(name,pwd,new ArrayList<>());
    }
}
