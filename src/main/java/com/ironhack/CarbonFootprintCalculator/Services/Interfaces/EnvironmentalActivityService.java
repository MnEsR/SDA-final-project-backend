package com.ironhack.CarbonFootprintCalculator.Services.Interfaces;

import com.ironhack.CarbonFootprintCalculator.Models.EnvironmentalActivity;

import java.util.List;

public interface EnvironmentalActivityService {
    List<EnvironmentalActivity> findAll();
    EnvironmentalActivity findById(Long id);
    EnvironmentalActivity create(EnvironmentalActivity environmentalActivity);
    EnvironmentalActivity update(Long id, EnvironmentalActivity updatedEnvironmentalActivity);
    boolean deleteById(Long id);
}

































//
//import com.ironhack.CarbonFootprintCalculator.Models.EnvironmentalActivity;
//import com.ironhack.CarbonFootprintCalculator.Repositories.EnvironmentalActivityRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class EnvironmentalActivityService {
//
//    private final EnvironmentalActivityRepo environmentalActivityRepo;
//
//    @Autowired
//    public EnvironmentalActivityService(EnvironmentalActivityRepo environmentalActivityRepo) {
//        this.environmentalActivityRepo = environmentalActivityRepo;
//    }
//
//    public List<EnvironmentalActivity> findAll() {
//        return environmentalActivityRepo.findAll();
//    }
//
//    public EnvironmentalActivity findById(Long id) {
//        Optional<EnvironmentalActivity> optionalActivity = environmentalActivityRepo.findById(id);
//        return optionalActivity.orElse(null);
//    }
//
//    public EnvironmentalActivity create(EnvironmentalActivity environmentalActivity) {
//        // You may want to perform additional checks or business logic before saving
//        return environmentalActivityRepo.save(environmentalActivity);
//    }
//
//    public EnvironmentalActivity update(Long id, EnvironmentalActivity updatedActivity) {
//        Optional<EnvironmentalActivity> optionalExistingActivity = environmentalActivityRepo.findById(id);
//        if (optionalExistingActivity.isPresent()) {
//            EnvironmentalActivity existingActivity = optionalExistingActivity.get();
//
//            // Update fields as needed
//            existingActivity.setActivityName(updatedActivity.getActivityName());
//            existingActivity.setDescription(updatedActivity.getDescription());
//            // Update other fields...
//
//            // Save the updated activity
//            return environmentalActivityRepo.save(existingActivity);
//        } else {
//            return null; // Activity not found
//        }
//    }
//
//    public boolean deleteById(Long id) {
//        if (environmentalActivityRepo.existsById(id)) {
//            environmentalActivityRepo.deleteById(id);
//            return true;
//        } else {
//            return false; // Activity not found
//        }
//    }
//}
