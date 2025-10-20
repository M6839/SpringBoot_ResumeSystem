package com.example.resumeBuilder.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.resumeBuilder.entity.Experience;
import com.example.resumeBuilder.entity.User;
import com.example.resumeBuilder.repository.ExperienceRepository;
import com.example.resumeBuilder.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ExperienceController {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/experience/{userId}")
    public Experience addExperience(@PathVariable Long userId, @RequestBody Experience experience) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        experience.setUser(user);
        return experienceRepository.save(experience);
    }

    @GetMapping("/experience/{userId}")
    public List<Experience> getUserExperiences(@PathVariable Long userId) {
        return experienceRepository.findByUserId(userId);
    }

    @PutMapping("/experience/{id}")
    public Experience updateExperience(@PathVariable Long id, @RequestBody Experience updated) {
        Experience exp = experienceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Experience not found"));
        exp.setCompany(updated.getCompany());
        exp.setPosition(updated.getPosition());
        exp.setDuration(updated.getDuration());
        exp.setDescription(updated.getDescription());
        return experienceRepository.save(exp);
    }

    @DeleteMapping("/experience/{id}")
    public String deleteExperience(@PathVariable Long id) {
        experienceRepository.deleteById(id);
        return "Experience deleted successfully";
    }
}
