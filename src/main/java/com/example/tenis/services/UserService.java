package com.example.tenis.services;

import com.example.tenis.models.User;
import com.example.tenis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        // You may want to add additional validation or processing here
        userRepository.save(user);
    }

    public User loginUser(User userDTO) {
        User user = userRepository.findByUsername(userDTO.getUsername());
        if (user != null && user.getPassword().equals(userDTO.getPassword())) {
            return new User(user.getId(), user.getUsername(), user.getEmail());
        }
        return null;
    }

    // Other methods for updating account information, etc.
}
