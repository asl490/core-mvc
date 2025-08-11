package com.asl.core.auth.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.asl.core.auth.entity.Role;
import com.asl.core.shared.BaseJpaRepository;

@Repository
public interface RoleRepository extends BaseJpaRepository<Role> {
    Optional<Role> findByName(String name);
}
