package com.asl.core.auth.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.asl.core.auth.entity.RefreshToken;
import com.asl.core.auth.entity.User;
import com.asl.core.shared.BaseJpaRepository;

@Repository
public interface RefreshTokenRepository extends BaseJpaRepository<RefreshToken> {
    Optional<RefreshToken> findByToken(String token);

    Optional<RefreshToken> findByUserId(Long userId);

    void deleteByUser(User user);
}