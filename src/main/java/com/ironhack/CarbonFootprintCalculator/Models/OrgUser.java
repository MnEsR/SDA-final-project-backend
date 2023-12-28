package com.ironhack.CarbonFootprintCalculator.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;



@Entity
public class OrgUser extends User{
    @Column(nullable = false)
    private String organizationName;
    @Column(nullable = false)
    private String contactPerson;

    public OrgUser() {

    }

    public OrgUser(String username, String email, String password, String organizationName, String contactPerson) {
        super(username, email, password);
        this.organizationName = organizationName;
        this.contactPerson = contactPerson;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }
}

