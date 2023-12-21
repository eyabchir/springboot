package com.example.Pharmacie.controller;

import com.example.Pharmacie.model.Medicament;
import com.example.Pharmacie.model.Order;
import com.example.Pharmacie.model.OrderMedicament;
import com.example.Pharmacie.repository.MedicamentRepository;
import com.example.Pharmacie.Service.OrderMedicamentService;
import com.example.Pharmacie.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private MedicamentRepository medicamentRepository;

    @GetMapping("/create")
    public String showCreateOrderPage(Model model) {
        List<Medicament> medicaments = medicamentRepository.findAll();
        model.addAttribute("medicaments", medicaments);
        model.addAttribute("order", new Order());
        return "createOrderPage";
    }

    @PostMapping("/save")
    public String saveOrder(@ModelAttribute Order order, Model model) {
        List<Medicament> medicaments = order.getMedicaments();

        if (medicaments != null) {
            for (Medicament medicament : medicaments) {
                // Create a new OrderMedicament instance
                OrderMedicament orderMedicament = new OrderMedicament();
                orderMedicament.setOrder(order);
                orderMedicament.setMedicament(medicament);
                
                
                OrderMedicamentService orderMedicamentService = new OrderMedicamentService(null);
				orderMedicamentService.saveOrderMedicament(orderMedicament);

                // Assuming you have bidirectional relationships in Medicament and OrderMedicament
                List<OrderMedicament> orderMedicamentList = medicament.getOrderMedicaments();
                orderMedicamentList.add(orderMedicament);
                medicament.setOrderMedicaments(orderMedicamentList);
            }
        }

        // Save the order and associated entities (Medicament and Order) using your service or repository
        orderService.saveOrder(order);

        Long id = order.getId(); // Assuming you want the ID of the order
        String successMessage = "Order with id: '" + id + "' created successfully!";
        model.addAttribute("successMessage", successMessage);
        return "createOrderPage";
    }
    @GetMapping("/order/all")
    public String getAllOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "allOrdersPage";
    }

}

