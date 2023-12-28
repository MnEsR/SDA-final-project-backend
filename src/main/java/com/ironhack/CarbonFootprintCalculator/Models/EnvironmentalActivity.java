package com.ironhack.CarbonFootprintCalculator.Models;


import jakarta.persistence.*;

@Entity
public class EnvironmentalActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column(nullable = false, length = 255)
    private String activityName;

    @Column(nullable = false, length = 1000)
    private String description;

    public EnvironmentalActivity() {

    }

    public EnvironmentalActivity(User user, String activityName, String description) {
        this.user = user;
        this.activityName = activityName;
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        // Checks for null and length constraints
        if (activityName == null || activityName.length() > 255) {
            throw new IllegalArgumentException("Activity name must not be null and must not exceed 255 characters.");
        }
        this.activityName = activityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        //Checks for null and length constraints
        if (description == null || description.length() > 1000) {
            throw new IllegalArgumentException("Description must not be null and must not exceed 1000 characters.");
        }

        this.description = description;
    }


}


