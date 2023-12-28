package com.ironhack.CarbonFootprintCalculator.Repositories;

import com.ironhack.CarbonFootprintCalculator.Models.EnvironmentalActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvironmentalActivityRepo extends JpaRepository<EnvironmentalActivity, Long> {
}
