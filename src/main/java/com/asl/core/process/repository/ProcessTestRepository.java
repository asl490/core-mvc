package com.asl.core.process.repository;

import org.springframework.stereotype.Repository;

import com.asl.core.process.entity.ProcessTest;
import com.asl.core.shared.BaseJpaRepository;

@Repository
public interface ProcessTestRepository extends BaseJpaRepository<ProcessTest> {
}