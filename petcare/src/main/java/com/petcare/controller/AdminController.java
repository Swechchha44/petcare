package com.petcare.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petcare.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private AdminService adminService;

    // ✅ Constructor Injection (IMPORTANT FIX)
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/test")
    public String testAdmin() {
        return "Admin Controller Working!";
    }
}
