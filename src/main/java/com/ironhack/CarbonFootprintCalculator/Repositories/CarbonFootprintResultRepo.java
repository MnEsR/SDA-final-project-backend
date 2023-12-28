package com.ironhack.CarbonFootprintCalculator.Repositories;

import com.ironhack.CarbonFootprintCalculator.Models.CarbonFootprintResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarbonFootprintResultRepo extends JpaRepository<CarbonFootprintResult, Long> {
}
