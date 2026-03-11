package com.petcare.service;

import com.petcare.entity.AppointmentSlot;

public interface AppointmentSlotService {

    AppointmentSlot createSlot(Long vetId, AppointmentSlot slot);

}