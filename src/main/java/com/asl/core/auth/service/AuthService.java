package com.asl.core.auth.service;

import com.asl.core.auth.dto.AuthResponse;
import com.asl.core.auth.dto.AuthenticationRequest;
import com.asl.core.auth.dto.RefreshTokenRequest;
import com.asl.core.auth.dto.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);

    AuthResponse authenticate(AuthenticationRequest request);

    AuthResponse refreshToken(RefreshTokenRequest request);

    void logout(RefreshTokenRequest request);
}