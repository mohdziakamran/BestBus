package com.example.bestbus;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class User {

    @Id
    private String id;
    private String firstName;
    private String lastname;
    private Gender gender;
    private Address address;
//    @Indexed(unique = true)
    private String email;
    private String phone;
    private int age;
    private LocalDateTime created;


    public User(String firstName, String lastname, Gender gender,
                Address address, String email, String phone, int age,LocalDateTime created) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.created=created;
    }



}
