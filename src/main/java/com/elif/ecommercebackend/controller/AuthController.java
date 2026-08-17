package com.elif.ecommercebackend.controller;

import com.elif.ecommercebackend.entity.User;
import com.elif.ecommercebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping({"/signup", "/auth/signup"})
    public ResponseEntity<?> signup(@RequestBody User user) {
        if (user.getRoleId() == null) {
            user.setRoleId(3L);
        }

        User savedUser = userRepository.save(user);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "User registered successfully");
        response.put("user", savedUser);

        return ResponseEntity.ok(response);
    }
}