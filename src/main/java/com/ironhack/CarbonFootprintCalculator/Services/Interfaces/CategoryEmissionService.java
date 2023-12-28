package com.ironhack.CarbonFootprintCalculator.Services.Interfaces;


import com.ironhack.CarbonFootprintCalculator.Models.CategoryEmission;

import java.util.List;

public interface CategoryEmissionService {
    List<CategoryEmission> findAll();
    CategoryEmission findById(Long id);
    CategoryEmission create(CategoryEmission categoryEmission);
    CategoryEmission update(Long id, CategoryEmission updatedCategoryEmission);
    boolean deleteById(Long id);
}





































//import com.ironhack.CarbonFootprintCalculator.Models.CategoryEmission;
//import com.ironhack.CarbonFootprintCalculator.Repositories.CategoryEmissionRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CategoryEmissionService {
//    private final CategoryEmissionRepo categoryEmissionRepo;
//
//    @Autowired
//    public CategoryEmissionService(CategoryEmissionRepo categoryEmissionRepo) {
//        this.categoryEmissionRepo = categoryEmissionRepo;
//    }
//
//    public List<CategoryEmission> findAll() {
//        return categoryEmissionRepo.findAll();
//    }
//
//    public CategoryEmission findById(Long id) {
//        Optional<CategoryEmission> optionalCategoryEmission = categoryEmissionRepo.findById(id);
//        return optionalCategoryEmission.orElse(null);
//    }
//
//    public CategoryEmission create(CategoryEmission categoryEmission) {
//        // You may want to perform additional checks or business logic before saving
//        return categoryEmissionRepo.save(categoryEmission);
//    }
//
//    public CategoryEmission update(Long id, CategoryEmission updatedCategoryEmission) {
//        Optional<CategoryEmission> optionalExistingCategoryEmission = categoryEmissionRepo.findById(id);
//        if (optionalExistingCategoryEmission.isPresent()) {
//            CategoryEmission existingCategoryEmission = optionalExistingCategoryEmission.get();
//
//            // Update fields as needed
//            existingCategoryEmission.setCategory(updatedCategoryEmission.getCategory());
//            existingCategoryEmission.setEmissions(updatedCategoryEmission.getEmissions());
//            // Update other fields...
//
//            // Save the updated category emission
//            return categoryEmissionRepo.save(existingCategoryEmission);
//        } else {
//            return null; // Category emission not found
//        }
//    }
//
//    public boolean deleteById(Long id) {
//        if (categoryEmissionRepo.existsById(id)) {
//            categoryEmissionRepo.deleteById(id);
//            return true;
//        } else {
//            return false; // Category emission not found
//        }
//    }}
