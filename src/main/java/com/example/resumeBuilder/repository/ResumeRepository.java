package com.example.resumeBuilder.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.resumeBuilder.entity.Resume;
import com.example.resumeBuilder.entity.User;

import java.util.Optional;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
    Optional<Resume> findByUser(User user);
    Optional<Resume> findByUserId(Long userId);
}
