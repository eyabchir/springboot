/*

package com.example.Pharmacie.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Pharmacie.model.Medicament;
import com.example.Pharmacie.model.Order;
import com.example.Pharmacie.repository.OrderRepository;




@Service
public class OrderService {
	

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders(Medicament medicament) {
        return orderRepository.findAll(medicament);
        
    }

    public Order findOrderByMedicament(Medicament medicament) {
        List<Order> orders = getAllOrders(medicament);
        return orders.isEmpty() ? null : orders.get(0);
    }

}
*/
