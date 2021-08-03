package com.example.bestbus;

import lombok.Data;

@Data
public class Address {
    private String line1,
    line2,
    country,
    state,
    city,
    pincode;

    public Address(String line1, String line2, String country, String state, String city, String pincode) {
        this.line1 = line1;
        this.line2 = line2;
        this.country = country;
        this.state = state;
        this.city = city;
        this.pincode = pincode;
    }
}
