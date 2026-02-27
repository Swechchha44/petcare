package com.petcare.controller;

import com.petcare.service.ProfileService;
import com.petcare.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private ProfileService profileService;

    // ✅ Constructor Injection (IMPORTANT)
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    // Get user profile
    @GetMapping("/{id}")
    public User getProfile(@PathVariable Long id) {
        return profileService.getUserById(id);
    }

    // Complete profile
    @PutMapping("/complete/{id}")
    public String completeProfile(@PathVariable Long id) {
        profileService.completeProfile(id);
        return "Profile completed successfully!";
    }

    // Update profile
    @PutMapping("/update/{id}")
    public User updateProfile(@PathVariable Long id, @RequestBody User updatedUser) {
        return profileService.updateProfile(id, updatedUser);
    }

    // Test endpoint
    @GetMapping("/test")
    public String test() {
        return "Profile Controller Working!";
    }
}
