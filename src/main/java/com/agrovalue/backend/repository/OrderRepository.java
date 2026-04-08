package com.agrovalue.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agrovalue.backend.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}