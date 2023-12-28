package com.ironhack.CarbonFootprintCalculator.Repositories;

import com.ironhack.CarbonFootprintCalculator.Models.OrgUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgUserRepo  extends JpaRepository<OrgUser, Long> {

}
