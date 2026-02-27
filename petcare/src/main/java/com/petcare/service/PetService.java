package com.petcare.service;

import com.petcare.dto.PetRequest;
import com.petcare.dto.PetResponse;

import java.util.List;

public interface PetService {

    PetResponse addPet(Long userId, PetRequest request);

    List<PetResponse> getUserPets(Long userId);

    PetResponse getPetById(Long petId);

    PetResponse updatePet(Long petId, PetRequest request);

    void deletePet(Long petId);
}