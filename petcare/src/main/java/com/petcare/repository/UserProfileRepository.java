package com.petcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petcare.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {}
