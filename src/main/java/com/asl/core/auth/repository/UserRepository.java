package com.asl.core.auth.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.asl.core.auth.entity.User;
import com.asl.core.shared.BaseJpaRepository;

@Repository
public interface UserRepository extends BaseJpaRepository<User> {
    Optional<User> findByUsername(String username);
}
