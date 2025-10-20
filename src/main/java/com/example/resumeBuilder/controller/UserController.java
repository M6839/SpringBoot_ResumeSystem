package com.example.resumeBuilder.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.resumeBuilder.entity.User;
import com.example.resumeBuilder.service.UserService;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
   

    @GetMapping("/me")
    public Map<String, Object> getProfile(@RequestHeader("Authorization") String token) {
        var user = userService.getUserProfile(token);
        return Map.of("user", user);
    }

    @PutMapping("/me")
    public Map<String, Object> updateProfile(@RequestHeader("Authorization") String token,
                                             @RequestBody User updatedUser) {
        var user = userService.getUserProfile(token);
        var resume = userService.updateProfile(token, updatedUser);
        return Map.of("user", user, "resume", resume);
    }
}
