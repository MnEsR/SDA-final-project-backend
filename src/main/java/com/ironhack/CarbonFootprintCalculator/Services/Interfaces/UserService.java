package com.ironhack.CarbonFootprintCalculator.Services.Interfaces;

import com.ironhack.CarbonFootprintCalculator.Models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    User createUser(User user);

    User updateUser(Long id, User updatedUser);

    boolean deleteUserById(Long id);
}



























//
//import com.ironhack.CarbonFootprintCalculator.Models.User;
//import com.ironhack.CarbonFootprintCalculator.Repositories.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserService {
//
//    private final UserRepo userRepository;
//
//    @Autowired
//    public UserService(UserRepo userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
//
//    public User findById(Long id) {
//        Optional<User> optionalUser = userRepository.findById(id);
//        return optionalUser.orElse(null);
//    }
//
//    public User createUser(User user) {
//        // You may want to perform additional checks or business logic before saving
//        return userRepository.save(user);
//    }
//
//    public User updateUser(Long id, User updatedUser) {
//        if (updatedUser == null) {
//            return null; // Invalid input
//        }
//
//        Optional<User> optionalExistingUser = userRepository.findById(id);
//        if (optionalExistingUser.isPresent()) {
//            User existingUser = optionalExistingUser.get();
//
//            // Update fields as needed
//            existingUser.setUsername(updatedUser.getUsername());
//            existingUser.setEmail(updatedUser.getEmail());
//            existingUser.setPassword(updatedUser.getPassword());
//            // Update other fields...
//
//            // Save the updated user
//            return userRepository.save(existingUser);
//        } else {
//            return null; // User not found
//        }
//    }
//
//    public boolean deleteUserById(Long id) {
//        if (userRepository.existsById(id)) {
//            userRepository.deleteById(id);
//            return true;
//        } else {
//            return false; // User not found
//        }
//    }
//
//}
