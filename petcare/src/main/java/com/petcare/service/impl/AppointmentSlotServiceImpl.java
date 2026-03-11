package com.petcare.service.impl;

import com.petcare.entity.AppointmentSlot;
import com.petcare.entity.Vet;
import com.petcare.repository.AppointmentSlotRepository;
import com.petcare.repository.VetRepository;
import com.petcare.service.AppointmentSlotService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentSlotServiceImpl implements AppointmentSlotService {

    private final AppointmentSlotRepository slotRepository;
    private final VetRepository vetRepository;

    @Override
    public AppointmentSlot createSlot(Long vetId, AppointmentSlot slot) {

        Vet vet = vetRepository.findById(vetId)
                .orElseThrow(() -> new RuntimeException("Vet not found"));

        slot.setVet(vet);
        slot.setAvailable(true);

        return slotRepository.save(slot);
    }
}