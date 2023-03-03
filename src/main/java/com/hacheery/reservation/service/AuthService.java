package com.hacheery.reservation.service;

import com.hacheery.reservation.payload.request.LoginRequest;
import com.hacheery.reservation.payload.request.RegisterRequest;
import com.hacheery.reservation.payload.response.AuthenticationResponse;
import org.springframework.http.ResponseEntity;

/**
 * Created by HachNV on Feb 21, 2023
 */

public interface AuthService {
    ResponseEntity<?> register(RegisterRequest request);
    AuthenticationResponse authenticate(LoginRequest request);
}
