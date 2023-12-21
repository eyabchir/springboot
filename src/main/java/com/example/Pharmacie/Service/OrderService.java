package com.example.Pharmacie.Service;

import com.example.Pharmacie.model.Order;
import com.example.Pharmacie.repository.OrderRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void saveOrder(Order order) {
        // You can add additional business logic here before saving
        orderRepository.save(order);
    }

	public List<Order> getAllOrders() {
		 return orderRepository.findAll();
	}

	public static void save(Order order) {
		// TODO Auto-generated method stub
		
	}
	
    // Other methods for updating, retrieving, deleting orders, etc.
}
