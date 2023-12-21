package com.example.Pharmacie.repository;

import com.example.Pharmacie.model.OrderMedicament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMedicamentRepository extends JpaRepository<OrderMedicament, Long> {
    // You can add custom query methods if needed
	
}
