package com.ironhack.CarbonFootprintCalculator.DTOs;

public class EnvironmentalActivityDTO {

    private Long userId;
    private String activityName;
    private String description;

    // Constructors, getters, and setters

    public EnvironmentalActivityDTO() {
    }

    public EnvironmentalActivityDTO(Long userId, String activityName, String description) {
        this.userId = userId;
        this.activityName = activityName;
        this.description = description;
    }

    // Getters and setters

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
