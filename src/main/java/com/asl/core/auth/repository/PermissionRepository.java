package com.asl.core.auth.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.asl.core.auth.entity.Permission;
import com.asl.core.shared.BaseJpaRepository;

@Repository
public interface PermissionRepository extends BaseJpaRepository<Permission> {
    Optional<Permission> findByName(String name);
}
