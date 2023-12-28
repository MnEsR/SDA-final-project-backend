package com.ironhack.CarbonFootprintCalculator.Repositories;

import com.ironhack.CarbonFootprintCalculator.Models.CategoryEmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryEmissionRepo extends JpaRepository<CategoryEmission, Long> {
}
