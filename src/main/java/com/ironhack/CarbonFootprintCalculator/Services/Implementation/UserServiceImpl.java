package com.ironhack.CarbonFootprintCalculator.Services.Implementation;

import com.ironhack.CarbonFootprintCalculator.Models.User;
import com.ironhack.CarbonFootprintCalculator.Repositories.UserRepo;
import com.ironhack.CarbonFootprintCalculator.Services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepository;

    @Autowired
    public UserServiceImpl(UserRepo userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public User createUser(User user) {
        // You may want to perform additional checks or business logic before saving
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        if (updatedUser == null) {
            return null; // Invalid input
        }

        Optional<User> optionalExistingUser = userRepository.findById(id);
        if (optionalExistingUser.isPresent()) {
            User existingUser = optionalExistingUser.get();

            // Update fields as needed
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            // Update other fields...

            // Save the updated user
            return userRepository.save(existingUser);
        } else {
            return null; // User not found
        }
    }

    @Override
    public boolean deleteUserById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false; // User not found
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

}
