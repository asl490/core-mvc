package com.asl.core.product.repository;

import org.springframework.stereotype.Repository;

import com.asl.core.product.entity.Product;
import com.asl.core.shared.BaseJpaRepository;

@Repository
public interface ProductRepository extends BaseJpaRepository<Product> {
}
