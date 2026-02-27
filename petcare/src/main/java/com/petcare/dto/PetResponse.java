package com.petcare.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PetResponse {

    private Long id;
    private String name;
    private String species;
    private String breed;
    private Integer age;
    private Double weight;
}