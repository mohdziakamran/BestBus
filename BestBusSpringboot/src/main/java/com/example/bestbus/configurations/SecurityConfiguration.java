package com.example.bestbus.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.bestbus.services.UserService;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	http.authorizeRequests()
    	.antMatchers("/login","/signup")
    	.permitAll()
    	.antMatchers("/account/**").hasAnyAuthority("USER")
    	.and()
    	.formLogin(form -> form
    			.defaultSuccessUrl("/account/home")
    			.loginPage("/login")
    			.failureUrl("/login?error=true")
    			);
    			
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
    	web.ignoring()
    	.antMatchers("/resources/**","/static/**");
    }
    
    
    @Bean
    public PasswordEncoder passwordEncoder(){
    	return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
    	DaoAuthenticationProvider authenticationProvider= new DaoAuthenticationProvider();
    	authenticationProvider.setPasswordEncoder(passwordEncoder());
    	authenticationProvider.setUserDetailsService(userService);
    	return authenticationProvider;
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.authenticationProvider(authProvider());
    } 
    
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManager() throws Exception {
//    	return super.authenticationManager();
//    }
    
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//    	// TODO Auto-generated method stub
//    	return super.authenticationManagerBean();
//    }
    
    
    
    
    
    
}






