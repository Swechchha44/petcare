package com.petcare.controller;

import com.petcare.dto.AppointmentRequest;
import com.petcare.entity.Appointment;
import com.petcare.service.AppointmentService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public Appointment bookAppointment(@RequestBody AppointmentRequest request) {

        Appointment appointment = new Appointment();
        appointment.setConsultationMode(request.getConsultationMode());
        appointment.setNotes(request.getNotes());

        return appointmentService.bookAppointment(
                request.getPetId(),
                request.getSlotId(),
                appointment
        );
    }
}