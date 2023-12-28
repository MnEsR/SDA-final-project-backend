package com.ironhack.CarbonFootprintCalculator.Controllers;

import com.ironhack.CarbonFootprintCalculator.Models.EnvironmentalActivity;
import com.ironhack.CarbonFootprintCalculator.Services.Interfaces.EnvironmentalActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/environmental-activities")
public class EnvironmentalActivityController {
    private final EnvironmentalActivityService environmentalActivityService;

    @Autowired
    public EnvironmentalActivityController(EnvironmentalActivityService environmentalActivityService) {
        this.environmentalActivityService = environmentalActivityService;
    }

    @GetMapping
    public ResponseEntity<List<EnvironmentalActivity>> getAllEnvironmentalActivities() {
        List<EnvironmentalActivity> environmentalActivities = environmentalActivityService.findAll();
        return new ResponseEntity<>(environmentalActivities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvironmentalActivity> getEnvironmentalActivityById(@PathVariable Long id) {
        EnvironmentalActivity environmentalActivity = environmentalActivityService.findById(id);
        if (environmentalActivity != null) {
            return new ResponseEntity<>(environmentalActivity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<EnvironmentalActivity> createEnvironmentalActivity(@RequestBody EnvironmentalActivity environmentalActivity) {
        EnvironmentalActivity createdActivity = environmentalActivityService.create(environmentalActivity);
        return new ResponseEntity<>(createdActivity, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnvironmentalActivity> updateEnvironmentalActivity(@PathVariable Long id, @RequestBody EnvironmentalActivity updatedActivity) {
        EnvironmentalActivity updatedEnvironmentalActivity = environmentalActivityService.update(id, updatedActivity);
        if (updatedEnvironmentalActivity != null) {
            return new ResponseEntity<>(updatedEnvironmentalActivity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnvironmentalActivity(@PathVariable Long id) {
        if (environmentalActivityService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
