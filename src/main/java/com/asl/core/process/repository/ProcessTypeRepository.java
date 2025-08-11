package com.asl.core.process.repository;

import org.springframework.stereotype.Repository;

import com.asl.core.process.entity.ProcessType;
import com.asl.core.shared.BaseJpaRepository;

@Repository
public interface ProcessTypeRepository extends BaseJpaRepository<ProcessType> {
}