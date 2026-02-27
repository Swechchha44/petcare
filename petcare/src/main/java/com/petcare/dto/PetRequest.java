package com.petcare.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PetRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String species;

    private String breed;

    @NotNull
    private Integer age;

    private Double weight;
}