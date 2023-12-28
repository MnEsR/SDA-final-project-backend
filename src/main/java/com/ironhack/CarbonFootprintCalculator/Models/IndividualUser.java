package com.ironhack.CarbonFootprintCalculator.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;



@Entity
public class IndividualUser extends User {
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;

    public IndividualUser(){

    }

    public IndividualUser(String username,
                          String email,
                          String password,
                          String firstName,
                          String lastName) {
        super(username, email, password);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}


