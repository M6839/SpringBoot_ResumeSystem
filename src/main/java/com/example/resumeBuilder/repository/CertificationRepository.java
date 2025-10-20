package com.example.resumeBuilder.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.resumeBuilder.entity.Certifications;

import java.util.List;


public interface CertificationRepository extends JpaRepository<Certifications, Long> {
    List<Certifications> findByUserId(Long userId);
}

