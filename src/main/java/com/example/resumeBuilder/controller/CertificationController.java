package com.example.resumeBuilder.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.resumeBuilder.entity.Certifications;
import com.example.resumeBuilder.entity.User;
import com.example.resumeBuilder.repository.CertificationRepository;
import com.example.resumeBuilder.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CertificationController {

    @Autowired
    private CertificationRepository certificationRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/certification/{userId}")
    public Certifications addCertification(@PathVariable Long userId, @RequestBody Certifications cert) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        cert.setUser(user);
        return certificationRepository.save(cert);
    }

    @GetMapping("/certification/{userId}")
    public List<Certifications> getCertifications(@PathVariable Long userId) {
        return certificationRepository.findByUserId(userId);
    }

    @PutMapping("/certification/{id}")
    public Certifications updateCertification(@PathVariable Long id, @RequestBody Certifications updated) {
        Certifications cert = certificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Certification not found"));
        cert.setName(updated.getName());
        cert.setOrganization(updated.getOrganization());
        cert.setIssueDate(updated.getIssueDate());
        cert.setExpiryDate(updated.getExpiryDate());
        return certificationRepository.save(cert);
    }

    @DeleteMapping("/certification/{id}")
    public String deleteCertification(@PathVariable Long id) {
        certificationRepository.deleteById(id);
        return "Certification deleted successfully";
    }
}
