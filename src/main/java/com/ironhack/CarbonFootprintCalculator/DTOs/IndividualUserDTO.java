package com.ironhack.CarbonFootprintCalculator.DTOs;

public class IndividualUserDTO extends UserDTO {

    private String firstName;
    private String lastName;

    // Constructors, getters, and setters

    public IndividualUserDTO() {
    }

    public IndividualUserDTO(String username, String email, String password, String firstName, String lastName) {
        super(username, email, password);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and setters

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
