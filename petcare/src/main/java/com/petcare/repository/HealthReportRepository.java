package com.petcare.repository;

import com.petcare.entity.HealthReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthReportRepository 
        extends JpaRepository<HealthReport, Long> {

    List<HealthReport> findByPetId(Long petId);
}