package com.ironhack.CarbonFootprintCalculator.Controllers;

import com.ironhack.CarbonFootprintCalculator.Models.IndividualUser;
import com.ironhack.CarbonFootprintCalculator.Services.Interfaces.IndividualUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/individual-users")
public class IndividualUserController {

    private final IndividualUserService individualUserService;

    @Autowired
    public IndividualUserController(IndividualUserService individualUserService) {
        this.individualUserService = individualUserService;
    }

//    @GetMapping
//    public ResponseEntity<List<IndividualUser>> getAllIndividualUsers() {
//        List<IndividualUser> individualUsers = individualUserService.findAll();
//        return new ResponseEntity<>(individualUsers, HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<IndividualUser> getIndividualUserById(@PathVariable Long id) {
        IndividualUser individualUser = individualUserService.findById(id);
        if (individualUser != null) {
            return new ResponseEntity<>(individualUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<IndividualUser> createIndividualUser(@RequestBody IndividualUser individualUser) {
        IndividualUser createdUser = individualUserService.createIndividualUser(individualUser);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IndividualUser> updateIndividualUser(@PathVariable Long id, @RequestBody IndividualUser updatedUser) {
        IndividualUser updatedIndividualUser = individualUserService.updateIndividualUser(id, updatedUser);
        if (updatedIndividualUser != null) {
            return new ResponseEntity<>(updatedIndividualUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIndividualUser(@PathVariable Long id) {
        if (individualUserService.deleteIndividualUserById(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
