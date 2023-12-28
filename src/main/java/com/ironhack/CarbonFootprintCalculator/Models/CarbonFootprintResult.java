package com.ironhack.CarbonFootprintCalculator.Models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class CarbonFootprintResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private Double totalCarbonFootprint;

    @OneToMany(mappedBy = "carbonFootprintResult", cascade = CascadeType.ALL)
    private List<CategoryEmission> categoryEmissions;

    public CarbonFootprintResult(User user, Double totalCarbonFootprint, List<CategoryEmission> categoryEmissions) {
        this.user = user;
        this.totalCarbonFootprint = totalCarbonFootprint;
        this.categoryEmissions = categoryEmissions;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getTotalCarbonFootprint() {
        return totalCarbonFootprint;
    }

    public void setTotalCarbonFootprint(Double totalCarbonFootprint) {
        this.totalCarbonFootprint = totalCarbonFootprint;
    }

    public List<CategoryEmission> getCategoryEmissions() {
        return categoryEmissions;
    }

    public void setCategoryEmissions(List<CategoryEmission> categoryEmissions) {
        this.categoryEmissions = categoryEmissions;
    }
}
