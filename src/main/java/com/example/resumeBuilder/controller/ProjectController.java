package com.example.resumeBuilder.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.resumeBuilder.entity.Project;
import com.example.resumeBuilder.entity.User;
import com.example.resumeBuilder.repository.ProjectRepository;
import com.example.resumeBuilder.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/project/{userId}")
    public Project addProject(@PathVariable Long userId, @RequestBody Project project) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        project.setUser(user);
        return projectRepository.save(project);
    }

    @GetMapping("/project/{userId}")
    public List<Project> getProjects(@PathVariable Long userId) {
        return projectRepository.findByUserId(userId);
    }

    @PutMapping("/project/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project updated) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        project.setTitle(updated.getTitle());
        project.setDescription(updated.getDescription());
        project.setTechnologies(updated.getTechnologies());
        project.setLink(updated.getLink());
        return projectRepository.save(project);
    }

    @DeleteMapping("/project/{id}")
    public String deleteProject(@PathVariable Long id) {
        projectRepository.deleteById(id);
        return "Project deleted successfully";
    }
}
