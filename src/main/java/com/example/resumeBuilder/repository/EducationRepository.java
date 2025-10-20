package com.example.resumeBuilder.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.resumeBuilder.entity.Education;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Long> {
    List<Education> findByUserId(Long userId);
}

