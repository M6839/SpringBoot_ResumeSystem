package com.example.resumeBuilder.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.resumeBuilder.entity.Experience;

import java.util.List;



public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    List<Experience> findByUserId(Long userId);
}

