package com.ironhack.CarbonFootprintCalculator.Services.Implementation;

import com.ironhack.CarbonFootprintCalculator.Models.EnvironmentalActivity;
import com.ironhack.CarbonFootprintCalculator.Repositories.EnvironmentalActivityRepo;
import com.ironhack.CarbonFootprintCalculator.Services.Interfaces.EnvironmentalActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EnvironmentalActivityServiceImpl implements EnvironmentalActivityService {

    private final EnvironmentalActivityRepo environmentalActivityRepo;

    @Autowired
    public EnvironmentalActivityServiceImpl(EnvironmentalActivityRepo environmentalActivityRepo) {
        this.environmentalActivityRepo = environmentalActivityRepo;
    }

    @Override
    public List<EnvironmentalActivity> findAll() {
        return environmentalActivityRepo.findAll();
    }

    @Override
    public EnvironmentalActivity findById(Long id) {
        Optional<EnvironmentalActivity> optionalEnvironmentalActivity = environmentalActivityRepo.findById(id);
        return optionalEnvironmentalActivity.orElse(null);
    }

    @Override
    public EnvironmentalActivity create(EnvironmentalActivity environmentalActivity) {
        // You may want to perform additional checks or business logic before saving
        return environmentalActivityRepo.save(environmentalActivity);
    }

    @Override
    public EnvironmentalActivity update(Long id, EnvironmentalActivity updatedEnvironmentalActivity) {
        Optional<EnvironmentalActivity> optionalExistingEnvironmentalActivity = environmentalActivityRepo.findById(id);
        if (optionalExistingEnvironmentalActivity.isPresent()) {
            EnvironmentalActivity existingEnvironmentalActivity = optionalExistingEnvironmentalActivity.get();

            // Update fields as needed
            existingEnvironmentalActivity.setActivityName(updatedEnvironmentalActivity.getActivityName());
            // Update other fields...

            // Save the updated environmental activity
            return environmentalActivityRepo.save(existingEnvironmentalActivity);
        } else {
            return null; // Environmental activity not found
        }
    }

    @Override
    public boolean deleteById(Long id) {
        if (environmentalActivityRepo.existsById(id)) {
            environmentalActivityRepo.deleteById(id);
            return true;
        } else {
            return false; // Environmental activity not found
        }
    }
}
