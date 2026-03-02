package com.petcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petcare.entity.HealthReport;
public interface HealthReportRepository
        extends JpaRepository<HealthReport, Long> {

    List<HealthReport> findByPetIdOrderByReportDateAsc(Long petId);
}