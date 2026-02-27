package com.petcare.service.impl;

import com.petcare.dto.PetRequest;
import com.petcare.dto.PetResponse;
import com.petcare.entity.Pet;
import com.petcare.entity.User;
import com.petcare.exception.CustomException;
import com.petcare.repository.PetRepository;
import com.petcare.repository.UserRepository;
import com.petcare.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final UserRepository userRepository;

    @Override
    public PetResponse addPet(Long userId, PetRequest request) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException("User not found"));

        Pet pet = Pet.builder()
                .name(request.getName())
                .species(request.getSpecies())
                .breed(request.getBreed())
                .age(request.getAge())
                .weight(request.getWeight())
                .user(user)
                .build();

        Pet saved = petRepository.save(pet);

        return mapToResponse(saved);
    }

    @Override
    public List<PetResponse> getUserPets(Long userId) {

        return petRepository.findByUserId(userId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PetResponse getPetById(Long petId) {

        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new CustomException("Pet not found"));

        return mapToResponse(pet);
    }

    @Override
    public PetResponse updatePet(Long petId, PetRequest request) {

        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new CustomException("Pet not found"));

        pet.setName(request.getName());
        pet.setSpecies(request.getSpecies());
        pet.setBreed(request.getBreed());
        pet.setAge(request.getAge());
        pet.setWeight(request.getWeight());

        Pet updated = petRepository.save(pet);

        return mapToResponse(updated);
    }

    @Override
    public void deletePet(Long petId) {

        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new CustomException("Pet not found"));

        petRepository.delete(pet);
    }

    private PetResponse mapToResponse(Pet pet) {
        return PetResponse.builder()
                .id(pet.getId())
                .name(pet.getName())
                .species(pet.getSpecies())
                .breed(pet.getBreed())
                .age(pet.getAge())
                .weight(pet.getWeight())
                .build();
    }
}