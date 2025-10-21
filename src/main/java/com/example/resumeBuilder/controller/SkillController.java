package com.example.resumeBuilder.controller;



import com.example.resumeBuilder.entity.Skill;
import com.example.resumeBuilder.entity.User;
import com.example.resumeBuilder.repository.SkillRepository;
import com.example.resumeBuilder.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/skills")
public class SkillController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SkillRepository skillRepository;
    
    @PostMapping("/{userId}")
    public Skill addSkill(@PathVariable Long userId, @RequestBody Skill skill) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        skill.setUser(user);
        return skillRepository.save(skill);
    }

   
    @GetMapping("/{userId}")
    public List<Skill> getSkillsByUser(@PathVariable Long userId) {
        return skillRepository.findByUserId(userId);
    }

   
   

    @DeleteMapping("/{id}")
    public String deleleSkill(@PathVariable Long id) {
        skillRepository.deleteById(id);
        return "skill deleted successfully";
    }

}