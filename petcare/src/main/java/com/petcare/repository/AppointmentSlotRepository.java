package com.petcare.repository;

import com.petcare.entity.AppointmentSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentSlotRepository extends JpaRepository<AppointmentSlot, Long> {
}