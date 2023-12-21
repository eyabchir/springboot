package com.example.Pharmacie.Service;

import com.example.Pharmacie.model.OrderMedicament;
import com.example.Pharmacie.repository.OrderMedicamentRepository;

import org.springframework.stereotype.Service;

@Service
public class OrderMedicamentService {

    private final OrderMedicamentRepository orderMedicamentRepository;

 
    public OrderMedicamentService(OrderMedicamentRepository orderMedicamentRepository) {
        this.orderMedicamentRepository = orderMedicamentRepository;
    }

    // You can add methods to perform CRUD operations or any other logic with OrderMedicament
    // For example:
   

        public void saveOrderMedicament(OrderMedicament orderMedicament) {
            orderMedicamentRepository.save(orderMedicament);
        }

        // Other methods...
    }


