package com.elif.ecommercebackend.controller;

import com.elif.ecommercebackend.entity.User;
import com.elif.ecommercebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

    @PostMapping({"/login", "/auth/login"})
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");

        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (user.getPassword() != null && user.getPassword().equals(password)) {
                Map<String, Object> response = new HashMap<>();
                response.put("id", user.getId());
                response.put("name", user.getName());
                response.put("email", user.getEmail());
                response.put("role_id", user.getRoleId());
                response.put("token", "dummy-jwt-token-" + user.getId() + "-" + System.currentTimeMillis());

                return ResponseEntity.ok(response);
            }
        }

        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", "Invalid email or password.");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }


    @GetMapping({"/verify", "/auth/verify"})
    public ResponseEntity<?> verifyToken(@RequestHeader(value = "Authorization", required = false) String token) {
        Map<String, Object> response = new HashMap<>();
        response.put("name", "Elif");
        response.put("email", "deneme@mail.com");
        response.put("role_id", 3L);
        response.put("token", (token != null && !token.isEmpty()) ? token : "dummy-jwt-token");

        return ResponseEntity.ok(response);
    }
}