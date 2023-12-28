package com.ironhack.CarbonFootprintCalculator.Controllers;

import com.ironhack.CarbonFootprintCalculator.Models.CategoryEmission;
import com.ironhack.CarbonFootprintCalculator.Services.Interfaces.CategoryEmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category-emissions")
public class CategoryEmissionController {

    private final CategoryEmissionService categoryEmissionService;

    @Autowired
    public CategoryEmissionController(CategoryEmissionService categoryEmissionService) {
        this.categoryEmissionService = categoryEmissionService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryEmission>> getAllCategoryEmissions() {
        List<CategoryEmission> categoryEmissions = categoryEmissionService.findAll();
        return new ResponseEntity<>(categoryEmissions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryEmission> getCategoryEmissionById(@PathVariable Long id) {
        CategoryEmission categoryEmission = categoryEmissionService.findById(id);
        if (categoryEmission != null) {
            return new ResponseEntity<>(categoryEmission, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CategoryEmission> createCategoryEmission(@RequestBody CategoryEmission categoryEmission) {
        CategoryEmission createdCategoryEmission = categoryEmissionService.create(categoryEmission);
        return new ResponseEntity<>(createdCategoryEmission, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryEmission> updateCategoryEmission(@PathVariable Long id, @RequestBody CategoryEmission updatedCategoryEmission) {
        CategoryEmission updatedCategoryEmissionEntity = categoryEmissionService.update(id, updatedCategoryEmission);
        if (updatedCategoryEmissionEntity != null) {
            return new ResponseEntity<>(updatedCategoryEmissionEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryEmission(@PathVariable Long id) {
        if (categoryEmissionService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
