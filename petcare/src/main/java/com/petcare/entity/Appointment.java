package com.petcare.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ONLINE or CLINIC
    private String consultationMode;

    // User notes about pet health
    private String notes;

    // Appointment status
    private String status = "PENDING";

    // Relationship with Pet
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    // Relationship with Appointment Slot
    @ManyToOne
    @JoinColumn(name = "slot_id")
    private AppointmentSlot slot;
}