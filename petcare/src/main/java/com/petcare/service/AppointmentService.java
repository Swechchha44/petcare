package com.petcare.service;

import com.petcare.entity.Appointment;

import java.util.List;

public interface AppointmentService {

    Appointment bookAppointment(Long petId, Long slotId, Appointment appointment);

    List<Appointment> getAppointments();

}