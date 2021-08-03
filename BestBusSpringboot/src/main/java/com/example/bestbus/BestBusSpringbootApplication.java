package com.example.bestbus;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class BestBusSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestBusSpringbootApplication.class, args);
	}

	@Bean
    CommandLineRunner runner (UserRepository repository){
	    return args -> {
//	        Address add=new Address("abc","bcd","INDIA","WB","Kolkata","700009");
//            User user=new User("ZIA","Kamran",Gender.MALE,add,
//                    "email@example.com","0987654321",10,LocalDateTime.now());
//            repository.insert(user);
        };
    }

}
