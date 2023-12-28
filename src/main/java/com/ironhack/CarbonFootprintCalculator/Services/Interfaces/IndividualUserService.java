package com.ironhack.CarbonFootprintCalculator.Services.Interfaces;


import com.ironhack.CarbonFootprintCalculator.Models.IndividualUser;

import java.util.List;

public interface IndividualUserService {
    List<IndividualUser> findAll();

    IndividualUser findById(Long id);

    IndividualUser createIndividualUser(IndividualUser individualUser);

    IndividualUser updateIndividualUser(Long id, IndividualUser updatedUser);

    boolean deleteIndividualUserById(Long id);
}





























//
//import com.ironhack.CarbonFootprintCalculator.Models.IndividualUser;
//import com.ironhack.CarbonFootprintCalculator.Repositories.IndividualUserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class IndividualUserService {
//    private final IndividualUserRepo individualUserRepository;
//
//    @Autowired
//    public IndividualUserService(IndividualUserRepo individualUserRepository) {
//        this.individualUserRepository = individualUserRepository;
//    }
//
//    public List<IndividualUser> findAll() {
//        return individualUserRepository.findAll();
//    }
//
//    public IndividualUser findById(Long id) {
//        Optional<IndividualUser> optionalUser = individualUserRepository.findById(id);
//        return optionalUser.orElse(null);
//    }
//
//    public IndividualUser createIndividualUser(IndividualUser individualUser) {
//        // You may want to perform additional checks or business logic before saving
//        return individualUserRepository.save(individualUser);
//    }
//
//    public IndividualUser updateIndividualUser(Long id, IndividualUser updatedUser) {
//        Optional<IndividualUser> optionalExistingUser = individualUserRepository.findById(id);
//        if (optionalExistingUser.isPresent()) {
//            IndividualUser existingUser = optionalExistingUser.get();
//
//            // Update fields as needed
//            existingUser.setFirstName(updatedUser.getFirstName());
//            existingUser.setLastName(updatedUser.getLastName());
//            // Update other fields...
//
//            // Save the updated user
//            return individualUserRepository.save(existingUser);
//        } else {
//            return null; // User not found
//        }
//    }
//
//    public boolean deleteIndividualUserById(Long id) {
//        if (individualUserRepository.existsById(id)) {
//            individualUserRepository.deleteById(id);
//            return true;
//        } else {
//            return false; // User not found
//        }
//    }
//
//
//}
