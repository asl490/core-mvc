package com.asl.core.auth.service.impl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asl.core.auth.dto.AuthResponse;
import com.asl.core.auth.dto.AuthenticationRequest;
import com.asl.core.auth.dto.RefreshTokenRequest;
import com.asl.core.auth.dto.RegisterRequest;
import com.asl.core.auth.entity.RefreshToken;
import com.asl.core.auth.entity.Role;
import com.asl.core.auth.entity.User;
import com.asl.core.auth.repository.RefreshTokenRepository;
import com.asl.core.auth.repository.RoleRepository;
import com.asl.core.auth.repository.UserRepository;
import com.asl.core.auth.service.AuthService;
import com.asl.core.auth.service.UserService;
import com.asl.core.exception.exception.ResourceNotFoundException;
import com.asl.core.security.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

        private final UserRepository userRepository;
        private final UserService userService;
        private final AuthenticationManager authenticationManager;
        private final JwtService jwtService;
        private final RefreshTokenRepository refreshTokenRepository;
        private final RoleRepository roleRepository;
        private final PasswordEncoder passwordEncoder;

        @Override
        @Transactional
        public AuthResponse register(RegisterRequest request) {
                List<Role> roles = new ArrayList<>();
                if (request.getRoleNames() == null || request.getRoleNames().isEmpty()) {
                        roles.add(roleRepository.findByName("USER")
                                        .orElseThrow(() -> new ResourceNotFoundException("Role USER not found")));
                } else {
                        request.getRoleNames().forEach(roleName -> roles.add(roleRepository.findByName(roleName)
                                        .orElseThrow(() -> new ResourceNotFoundException(
                                                        "Role " + roleName + " not found"))));
                }

                User user = User.builder()
                                .username(request.getUsername())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .roles(roles)
                                .build();

                User createdUser = userRepository.save(user);

                String jwt = jwtService.generateToken(createdUser);
                RefreshToken refreshToken = createRefreshToken(createdUser);

                return AuthResponse.builder()
                                .accessToken(jwt)
                                .refreshToken(refreshToken.getToken())
                                .build();
        }

        @Override
        @Transactional
        public AuthResponse authenticate(AuthenticationRequest request) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
                User user = userService.getUserByUsername(request.getUsername())
                                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
                String jwt = jwtService.generateToken(user);
                RefreshToken refreshToken = createRefreshToken(user);
                return AuthResponse.builder()
                                .accessToken(jwt)
                                .refreshToken(refreshToken.getToken())
                                .build();
        }

        @Override
        @Transactional
        public AuthResponse refreshToken(RefreshTokenRequest request) {
                RefreshToken refreshToken = refreshTokenRepository.findByToken(request.getRefreshToken())
                                .orElseThrow(() -> new ResourceNotFoundException("Refresh Token is not in DB!"));

                if (refreshToken.getExpiryDate().isBefore(Instant.now())) {
                        refreshTokenRepository.delete(refreshToken);
                        throw new RuntimeException("Refresh token was expired. Please make a new signin request");
                }

                refreshTokenRepository.delete(refreshToken);
                User user = refreshToken.getUser();
                String newAccessToken = jwtService.generateToken(user);
                RefreshToken newRefreshToken = createRefreshToken(user);

                return AuthResponse.builder()
                                .accessToken(newAccessToken)
                                .refreshToken(newRefreshToken.getToken())
                                .build();
        }

        private RefreshToken createRefreshToken(User user) {
                RefreshToken refreshToken = RefreshToken.builder()
                                .user(user)
                                .token(UUID.randomUUID().toString())
                                .expiryDate(Instant.now().plusMillis(jwtService.getRefreshExpiration()))
                                .build();
                return refreshTokenRepository.save(refreshToken);
        }

        @Override
        @Transactional
        public void logout(RefreshTokenRequest request) {
                refreshTokenRepository.findByToken(request.getRefreshToken())
                                .ifPresent(refreshTokenRepository::delete);
        }
}