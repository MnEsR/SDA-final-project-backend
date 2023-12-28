package com.ironhack.CarbonFootprintCalculator.Services.Implementation;

import com.ironhack.CarbonFootprintCalculator.Models.CarbonFootprintResult;
import com.ironhack.CarbonFootprintCalculator.Repositories.CarbonFootprintResultRepo;
import com.ironhack.CarbonFootprintCalculator.Services.Interfaces.CarbonFootprintResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarbonFootprintResultServiceImpl implements CarbonFootprintResultService {

    private final CarbonFootprintResultRepo carbonFootprintResultRepo;

    @Autowired
    public CarbonFootprintResultServiceImpl(CarbonFootprintResultRepo carbonFootprintResultRepo) {
        this.carbonFootprintResultRepo = carbonFootprintResultRepo;
    }

    @Override
    public List<CarbonFootprintResult> findAll() {
        return carbonFootprintResultRepo.findAll();
    }

    @Override
    public CarbonFootprintResult findById(Long id) {
        Optional<CarbonFootprintResult> optionalResult = carbonFootprintResultRepo.findById(id);
        return optionalResult.orElse(null);
    }

    @Override
    public CarbonFootprintResult create(CarbonFootprintResult carbonFootprintResult) {
        // You may want to perform additional checks or business logic before saving
        return carbonFootprintResultRepo.save(carbonFootprintResult);
    }

    @Override
    public CarbonFootprintResult update(Long id, CarbonFootprintResult updatedResult) {
        Optional<CarbonFootprintResult> optionalExistingResult = carbonFootprintResultRepo.findById(id);
        if (optionalExistingResult.isPresent()) {
            CarbonFootprintResult existingResult = optionalExistingResult.get();

            // Update fields as needed
            existingResult.setTotalCarbonFootprint(updatedResult.getTotalCarbonFootprint());
            existingResult.setCategoryEmissions(updatedResult.getCategoryEmissions());
            // Update other fields...

            // Save the updated result
            return carbonFootprintResultRepo.save(existingResult);
        } else {
            return null; // Result not found
        }
    }

    @Override
    public boolean deleteById(Long id) {
        if (carbonFootprintResultRepo.existsById(id)) {
            carbonFootprintResultRepo.deleteById(id);
            return true;
        } else {
            return false; // Result not found
        }
    }

}
