package com.petcare.service.impl;

import com.petcare.entity.Vet;
import com.petcare.repository.VetRepository;
import com.petcare.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VetServiceImpl implements VetService {

    private final VetRepository vetRepository;

    @Override
    public Vet saveVet(Vet vet) {
        return vetRepository.save(vet);
    }
}