package com.example.bestbus.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.bestbus.exceptions.UserAlreadyExistException;
import com.example.bestbus.model.SignupRequest;
import com.example.bestbus.model.User;
import com.example.bestbus.repository.UserRepository;

@Service
public class UserService implements UserDetailsService,
							 UserSignupService
							 {

	@Autowired
    private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

/*
 * 	Override Userdeatilservice method
 */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
        User foundedUser =userRepository.findByEmail(username);
        
        if(foundedUser==null) {
        	throw new UsernameNotFoundException(username);
        }
        UserDetails user= org.springframework.security.core.userdetails.User
        		.withUsername(foundedUser.getEmail())
        		.password(foundedUser.getPassword())
        		.authorities("USER").build();
        

        return user;
    }
    
/*
 *  methods for signup
 */
    @Override
    public void register(final SignupRequest signupRequest) throws UserAlreadyExistException {
    	if(checkIfUserExist(signupRequest.getEmail())) {
    		throw new UserAlreadyExistException("User Already Exist");
    	}
    	User user=new User();
    	BeanUtils.copyProperties(signupRequest, user);
    	encodePassword(signupRequest, user);
    	userRepository.save(user);
    	
	}
    @Override
    public boolean checkIfUserExist(String email) {
    	return (userRepository.findByEmail(email)!=null) ? true : false;
	}
    @Override
    public void encodePassword(SignupRequest signupRequest,User user) {
    	user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
	}
    
    
    
}
