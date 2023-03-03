package com.hacheery.reservation.controller;

import com.hacheery.reservation.payload.request.LoginRequest;
import com.hacheery.reservation.payload.request.RegisterRequest;
import com.hacheery.reservation.payload.response.AuthenticationResponse;
import com.hacheery.reservation.payload.response.MessageResponse;
import com.hacheery.reservation.repository.UserRepository;
import com.hacheery.reservation.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * Created by HachNV on Feb 25, 2023
 */
@RestController
@CrossOrigin(origins = "*", maxAge = -1)
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthService authService;
    private final UserRepository userRepository;

    @PostMapping("/register")
    @CrossOrigin
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        if(userRepository.existsByEmail(request.getEmail())){
            return ResponseEntity.badRequest().body(new MessageResponse(400,"Email is already registered!"));
        }
        if(!StringUtils.hasLength(request.getName()) || !StringUtils.hasLength(request.getEmail()) || !StringUtils.hasLength(request.getPhone())) {
            return ResponseEntity.badRequest().body(new MessageResponse(400, "Please input missing information"));
       }
        try {
            authService.register(request);
            return ResponseEntity.ok("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            AuthenticationResponse token = authService.authenticate(request);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new MessageResponse(400, "Email or Password is incorrect!"));
        }
    }
}
