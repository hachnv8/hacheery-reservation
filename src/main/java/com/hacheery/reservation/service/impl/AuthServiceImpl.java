package com.hacheery.reservation.service.impl;

import com.hacheery.reservation.entity.User;
import com.hacheery.reservation.payload.request.LoginRequest;
import com.hacheery.reservation.payload.request.RegisterRequest;
import com.hacheery.reservation.payload.response.AuthenticationResponse;
import com.hacheery.reservation.payload.response.MessageResponse;
import com.hacheery.reservation.repository.UserRepository;
import com.hacheery.reservation.service.AuthService;
import com.hacheery.reservation.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by HachNV on Mar 01, 2023
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<?> register(RegisterRequest request) {
        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .dob(request.getDob())
                .gender(request.getGender())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .enabled(true)
                .build();
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse(200, "User registered successfully!"));
    }

    @Override

    public AuthenticationResponse authenticate(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByEmail(request.getUsername()).orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }
}
