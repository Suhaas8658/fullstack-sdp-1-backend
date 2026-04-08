package com.agrovalue.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agrovalue.backend.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}