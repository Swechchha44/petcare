package com.petcare.service.impl;

import com.petcare.entity.Appointment;
import com.petcare.entity.AppointmentSlot;
import com.petcare.entity.Pet;
import com.petcare.repository.AppointmentRepository;
import com.petcare.repository.AppointmentSlotRepository;
import com.petcare.repository.PetRepository;
import com.petcare.service.AppointmentService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PetRepository petRepository;
    private final AppointmentSlotRepository slotRepository;

    @Override
    public Appointment bookAppointment(Long petId, Long slotId, Appointment appointment) {

        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("Pet not found"));

        AppointmentSlot slot = slotRepository.findById(slotId)
                .orElseThrow(() -> new RuntimeException("Slot not found"));

        // Check slot availability
        if (!slot.isAvailable()) {
            throw new RuntimeException("Slot already booked");
        }

        appointment.setPet(pet);
        appointment.setSlot(slot);
        appointment.setStatus("PENDING");

        Appointment saved = appointmentRepository.save(appointment);

        // mark slot unavailable
        slot.setAvailable(false);
        slotRepository.save(slot);

        return saved;
    }

    @Override
    public List<Appointment> getAppointments() {
        return appointmentRepository.findAll();
    }
}