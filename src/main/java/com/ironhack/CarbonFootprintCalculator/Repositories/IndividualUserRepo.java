package com.ironhack.CarbonFootprintCalculator.Repositories;

import com.ironhack.CarbonFootprintCalculator.Models.IndividualUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualUserRepo extends JpaRepository<IndividualUser, Long> {
}
