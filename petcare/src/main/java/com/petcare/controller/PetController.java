package com.petcare.controller;

import com.petcare.dto.PetRequest;
import com.petcare.dto.PetResponse;
import com.petcare.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    // ✅ Add Pet
    @PostMapping
    public ResponseEntity<PetResponse> addPet(
            @PathVariable Long userId,
            @Valid @RequestBody PetRequest request) {

        PetResponse response = petService.addPet(userId, request);
        return ResponseEntity.ok(response);
    }

    // ✅ Get All Pets of User
    @GetMapping
    public ResponseEntity<List<PetResponse>> getUserPets(
            @PathVariable Long userId) {

        List<PetResponse> pets = petService.getUserPets(userId);
        return ResponseEntity.ok(pets);
    }

    // ✅ Get Single Pet
    @GetMapping("/{petId}")
    public ResponseEntity<PetResponse> getPetById(
            @PathVariable Long petId) {

        return ResponseEntity.ok(petService.getPetById(petId));
    }

    // ✅ Update Pet
    @PutMapping("/{petId}")
    public ResponseEntity<PetResponse> updatePet(
            @PathVariable Long petId,
            @Valid @RequestBody PetRequest request) {

        return ResponseEntity.ok(petService.updatePet(petId, request));
    }

    // ✅ Delete Pet
    @DeleteMapping("/{petId}")
    public ResponseEntity<String> deletePet(
            @PathVariable Long petId) {

        petService.deletePet(petId);
        return ResponseEntity.ok("Pet deleted successfully");
    }
}