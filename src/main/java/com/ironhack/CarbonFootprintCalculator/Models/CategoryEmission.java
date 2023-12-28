package com.ironhack.CarbonFootprintCalculator.Models;

import jakarta.persistence.*;


@Entity
public class CategoryEmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private CarbonFootprintResult carbonFootprintResult;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Double emissions;

    public CategoryEmission() {

    }

    public CategoryEmission(CarbonFootprintResult carbonFootprintResult, String category, Double emissions) {
        this.carbonFootprintResult = carbonFootprintResult;
        this.category = category;
        this.emissions = emissions;
    }

    public CarbonFootprintResult getCarbonFootprintResult() {
        return carbonFootprintResult;
    }

    public void setCarbonFootprintResult(CarbonFootprintResult carbonFootprintResult) {
        this.carbonFootprintResult = carbonFootprintResult;
    }

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
