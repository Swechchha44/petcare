package com.petcare.controller;

import com.petcare.entity.Vet;
import com.petcare.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vets")
@RequiredArgsConstructor
public class VetController {

    private final VetService vetService;

    @PostMapping
    public Vet addVet(@RequestBody Vet vet) {
        return vetService.saveVet(vet);
    }
}