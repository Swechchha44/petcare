package com.petcare.service;

import com.petcare.entity.User;
import com.petcare.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private UserRepository userRepository;

    public ProfileService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void completeProfile(Long id) {
        User user = getUserById(id);
        user.setProfileCompleted(true);
        userRepository.save(user);
    }

    public User updateProfile(Long id, User updatedUser) {
        User user = getUserById(id);

        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());

        return userRepository.save(user);
    }
}
