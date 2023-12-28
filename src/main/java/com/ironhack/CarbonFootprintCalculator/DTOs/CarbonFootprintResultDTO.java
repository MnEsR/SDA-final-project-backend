package com.ironhack.CarbonFootprintCalculator.DTOs;

import java.util.List;

public class CarbonFootprintResultDTO {

    private Double totalCarbonFootprint;
    private List<CategoryEmissionDTO> categoryEmissions;

    // Constructors, getters, and setters

    public CarbonFootprintResultDTO() {
    }

    public CarbonFootprintResultDTO(Double totalCarbonFootprint, List<CategoryEmissionDTO> categoryEmissions) {
        this.totalCarbonFootprint = totalCarbonFootprint;
        this.categoryEmissions = categoryEmissions;
    }

    // Getters and setters

    public Double getTotalCarbonFootprint() {
        return totalCarbonFootprint;
    }

    public void setTotalCarbonFootprint(Double totalCarbonFootprint) {
        this.totalCarbonFootprint = totalCarbonFootprint;
    }

    public List<CategoryEmissionDTO> getCategoryEmissions() {
        return categoryEmissions;
    }

    public void setCategoryEmissions(List<CategoryEmissionDTO> categoryEmissions) {
        this.categoryEmissions = categoryEmissions;
    }
}
