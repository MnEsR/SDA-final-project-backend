package com.ironhack.CarbonFootprintCalculator.Services.Implementation;

import com.ironhack.CarbonFootprintCalculator.Models.CarbonFootprintResult;
import com.ironhack.CarbonFootprintCalculator.Models.CategoryEmission;
import com.ironhack.CarbonFootprintCalculator.Repositories.CarbonFootprintResultRepo;
import com.ironhack.CarbonFootprintCalculator.Repositories.CategoryEmissionRepo;
import com.ironhack.CarbonFootprintCalculator.Services.Interfaces.CarbonFootprintResultService;
import com.ironhack.CarbonFootprintCalculator.Services.Interfaces.CategoryEmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryEmissionServiceImpl implements CategoryEmissionService {
    private final CategoryEmissionRepo categoryEmissionRepo;

    @Autowired
    public CategoryEmissionServiceImpl(CategoryEmissionRepo categoryEmissionRepo) {
        this.categoryEmissionRepo = categoryEmissionRepo;
    }

    @Override
    public List<CategoryEmission> findAll() {
        return categoryEmissionRepo.findAll();
    }

    @Override
    public CategoryEmission findById(Long id) {
        Optional<CategoryEmission> optionalCategoryEmission = categoryEmissionRepo.findById(id);
        return optionalCategoryEmission.orElse(null);
    }

    @Override
    public CategoryEmission create(CategoryEmission categoryEmission) {
        // You may want to perform additional checks or business logic before saving
        return categoryEmissionRepo.save(categoryEmission);
    }

    @Override
    public CategoryEmission update(Long id, CategoryEmission updatedCategoryEmission) {
        Optional<CategoryEmission> optionalExistingCategoryEmission = categoryEmissionRepo.findById(id);
        if (optionalExistingCategoryEmission.isPresent()) {
            CategoryEmission existingCategoryEmission = optionalExistingCategoryEmission.get();

            // Update fields as needed
            existingCategoryEmission.setCategory(updatedCategoryEmission.getCategory());
            existingCategoryEmission.setEmissions(updatedCategoryEmission.getEmissions());
            // Update other fields...

            // Save the updated category emission
            return categoryEmissionRepo.save(existingCategoryEmission);
        } else {
            return null; // Category emission not found
        }
    }

    @Override
    public boolean deleteById(Long id) {
        if (categoryEmissionRepo.existsById(id)) {
            categoryEmissionRepo.deleteById(id);
            return true;
        } else {
            return false; // Category emission not found
        }
    }
}
