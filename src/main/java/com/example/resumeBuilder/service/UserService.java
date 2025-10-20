package com.example.resumeBuilder.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.resumeBuilder.entity.User;
import com.example.resumeBuilder.repository.UserRepository;
import com.example.resumeBuilder.security.JwtUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private JwtUtil jwtUtil;

   

    // Get user details from JWT token
    public User getUserFromToken(String token) {
        String email = jwtUtil.extractEmail(token.substring(7));
        return userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Get user profile
    public User getUserProfile(String token) {
        return getUserFromToken(token);
    }

    // Update user profile and regenerate resume
    public String updateProfile(String token, User updatedUser) {
        User user = getUserFromToken(token);

        user.setName(updatedUser.getName());
        user.setLocation(updatedUser.getLocation());
        user.setPhone(updatedUser.getPhone());
        user.setGithub(updatedUser.getGithub());
        user.setLinkedin(updatedUser.getLinkedin());
        user.setPortfolio(updatedUser.getPortfolio());
        userRepo.save(user);

       
        return "updated";
    }
}
