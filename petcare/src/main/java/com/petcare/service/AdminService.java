package com.petcare.service;

import com.petcare.repository.UserRepository;
import com.petcare.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private UserRepository userRepo;

    // ✅ Constructor Injection (FIX)
    public AdminService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User approveUser(Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setApproved(true);
        return userRepo.save(user);
    }
}
