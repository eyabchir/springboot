package com.example.Pharmacie.repository;

import com.example.Pharmacie.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // You can add custom query methods if needed
}