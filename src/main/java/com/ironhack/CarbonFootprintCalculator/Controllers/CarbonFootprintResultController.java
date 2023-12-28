package com.ironhack.CarbonFootprintCalculator.Controllers;

import com.ironhack.CarbonFootprintCalculator.Models.CarbonFootprintResult;
import com.ironhack.CarbonFootprintCalculator.Services.Interfaces.CarbonFootprintResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CarbonFootprintResultController {
    private final CarbonFootprintResultService carbonFootprintResultService;

    @Autowired
    public CarbonFootprintResultController(CarbonFootprintResultService carbonFootprintResultService) {
        this.carbonFootprintResultService = carbonFootprintResultService;
    }

    @GetMapping
    public ResponseEntity<List<CarbonFootprintResult>> getAllCarbonFootprintResults() {
        List<CarbonFootprintResult> carbonFootprintResults = carbonFootprintResultService.findAll();
        return new ResponseEntity<>(carbonFootprintResults, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarbonFootprintResult> getCarbonFootprintResultById(@PathVariable Long id) {
        CarbonFootprintResult carbonFootprintResult = carbonFootprintResultService.findById(id);
        if (carbonFootprintResult != null) {
            return new ResponseEntity<>(carbonFootprintResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CarbonFootprintResult> createCarbonFootprintResult(@RequestBody CarbonFootprintResult carbonFootprintResult) {
        CarbonFootprintResult createdResult = carbonFootprintResultService.create(carbonFootprintResult);
        return new ResponseEntity<>(createdResult, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarbonFootprintResult> updateCarbonFootprintResult(@PathVariable Long id, @RequestBody CarbonFootprintResult updatedResult) {
        CarbonFootprintResult updatedCarbonFootprintResult = carbonFootprintResultService.update(id, updatedResult);
        if (updatedCarbonFootprintResult != null) {
            return new ResponseEntity<>(updatedCarbonFootprintResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarbonFootprintResult(@PathVariable Long id) {
        if (carbonFootprintResultService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
