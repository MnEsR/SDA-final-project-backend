package com.ironhack.CarbonFootprintCalculator.DTOs;

public class CategoryEmissionDTO {
    private String category;
    private Double emissions;

    // Constructors, getters, and setters

    public CategoryEmissionDTO() {
    }

    public CategoryEmissionDTO(String category, Double emissions) {
        this.category = category;
        this.emissions = emissions;
    }

    // Getters and setters

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getEmissions() {
        return emissions;
    }

    public void setEmissions(Double emissions) {
        this.emissions = emissions;
    }
}
