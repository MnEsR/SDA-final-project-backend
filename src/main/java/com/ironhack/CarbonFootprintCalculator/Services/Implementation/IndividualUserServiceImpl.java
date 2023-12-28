package com.ironhack.CarbonFootprintCalculator.Services.Implementation;

import com.ironhack.CarbonFootprintCalculator.Models.IndividualUser;
import com.ironhack.CarbonFootprintCalculator.Repositories.IndividualUserRepo;
import com.ironhack.CarbonFootprintCalculator.Services.Interfaces.IndividualUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class IndividualUserServiceImpl implements IndividualUserService {

    private final IndividualUserRepo individualUserRepository;

    @Autowired
    public IndividualUserServiceImpl(IndividualUserRepo individualUserRepository) {
        this.individualUserRepository = individualUserRepository;
    }

    @Override
    public List<IndividualUser> findAll() {
        return individualUserRepository.findAll();
    }

    @Override
    public IndividualUser findById(Long id) {
        Optional<IndividualUser> optionalUser = individualUserRepository.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public IndividualUser createIndividualUser(IndividualUser individualUser) {
        // You may want to perform additional checks or business logic before saving
        return individualUserRepository.save(individualUser);
    }

    @Override
    public IndividualUser updateIndividualUser(Long id, IndividualUser updatedUser) {
        Optional<IndividualUser> optionalExistingUser = individualUserRepository.findById(id);
        if (optionalExistingUser.isPresent()) {
            IndividualUser existingUser = optionalExistingUser.get();

            // Update fields as needed
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            // Update other fields...

            // Save the updated user
            return individualUserRepository.save(existingUser);
        } else {
            return null; // User not found
        }
    }

    @Override
    public boolean deleteIndividualUserById(Long id) {
        if (individualUserRepository.existsById(id)) {
            individualUserRepository.deleteById(id);
            return true;
        } else {
            return false; // User not found
        }
    }

}
