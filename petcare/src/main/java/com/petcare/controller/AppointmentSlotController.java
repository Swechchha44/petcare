package com.petcare.controller;

import com.petcare.entity.AppointmentSlot;
import com.petcare.service.AppointmentSlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/slots")
@RequiredArgsConstructor
public class AppointmentSlotController {

    private final AppointmentSlotService slotService;

    @PostMapping("/vet/{vetId}")
    public AppointmentSlot createSlot(
            @PathVariable Long vetId,
            @RequestBody AppointmentSlot slot) {

        return slotService.createSlot(vetId, slot);
    }
}