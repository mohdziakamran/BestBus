package com.example.bestbus.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.example.bestbus.services.RememberMeTokenRepositoryService;
import com.example.bestbus.services.UserService;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;
//    @Autowired
//    private RememberMeTokenRepositoryService rememberMeTokenRepositoryService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	http
    		.authorizeRequests()
    		.antMatchers("/login","/signup")
    			.permitAll()
    		.antMatchers("/account/**").hasAnyAuthority("USER")
    		
    		.and()
    			.rememberMe().tokenRepository(persistentTokenRepository())
    			.userDetailsService(userService)
    			.tokenValiditySeconds(2*60)//2min

    		.and()
	    		.formLogin()
	    		.defaultSuccessUrl("/account/home")
				.loginPage("/login")
				.failureUrl("/login?error=true")
			
			.and()
    			.sessionManagement()
    			.maximumSessions(1)
    			.expiredUrl("/login?invalid-session=true")
    			
    			
    	;
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
    
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
    	return new RememberMeTokenRepositoryService();
    }
    
    @Bean
    public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}
    
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
    	return new HttpSessionEventPublisher();
    }
    
    
    
}






