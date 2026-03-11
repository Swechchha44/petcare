package com.petcare.dto;

import lombok.Data;

@Data
public class AppointmentRequest {

    private Long petId;
    private Long slotId;
    private String consultationMode;
    private String notes;

}