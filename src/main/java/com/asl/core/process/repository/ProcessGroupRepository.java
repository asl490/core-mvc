package com.asl.core.process.repository;

import org.springframework.stereotype.Repository;

import com.asl.core.process.entity.ProcessGroup;
import com.asl.core.shared.BaseJpaRepository;

@Repository
public interface ProcessGroupRepository extends BaseJpaRepository<ProcessGroup> {
}