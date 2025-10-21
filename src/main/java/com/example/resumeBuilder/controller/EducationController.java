package com.example.resumeBuilder.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.resumeBuilder.entity.Education;
import com.example.resumeBuilder.entity.User;
import com.example.resumeBuilder.repository.EducationRepository;
import com.example.resumeBuilder.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EducationController {

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private UserRepository userRepository;

  
    @PostMapping("/education/{userId}")
    public Education addEducation(@PathVariable Long userId, @RequestBody Education education) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        education.setUser(user);
        return educationRepository.save(education);
    }

   
    @GetMapping("/education/{userId}")
    public List<Education> getEducationsByUser(@PathVariable Long userId) {
        return educationRepository.findByUserId(userId);
    }

   
    @PutMapping("/education/{id}")
    public Education updateEducation(@PathVariable Long id, @RequestBody Education updatedEdu) {
        Education existing = educationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Education not found"));

        existing.setInstistution(updatedEdu.getInstistution());
        existing.setDegree(updatedEdu.getDegree());
        existing.setCgpa(updatedEdu.getCgpa());
        existing.setYear(updatedEdu.getYear());
        existing.setAchievements(updatedEdu.getAchievements());
        return educationRepository.save(existing);
    }


    @DeleteMapping("/education/{id}")
    public String deleteEducation(@PathVariable Long id) {
        educationRepository.deleteById(id);
        return "Education deleted successfully";
    }
}
