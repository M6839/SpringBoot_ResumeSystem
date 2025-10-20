package com.example.resumeBuilder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.resumeBuilder.entity.Skill;



public interface SkillRepository extends JpaRepository<Skill, Long> {

	List<Skill> findByUserId(Long userId);

}
