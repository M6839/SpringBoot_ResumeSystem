package com.example.resumeBuilder.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.resumeBuilder.entity.Project;

import java.util.List;



public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByUserId(Long userId);
}