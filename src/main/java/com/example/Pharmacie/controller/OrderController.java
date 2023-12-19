/*package com.example.Pharmacie.controller;

import com.example.Pharmacie.Service.OrderService;
import com.example.Pharmacie.model.Medicament;
import com.example.Pharmacie.model.Order;
import com.example.Pharmacie.model.OrderItem;
import com.example.Pharmacie.repository.MedicamentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private MedicamentRepository medicamentRepository;

    @GetMapping("/")
    public String getAllOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("list", orders);
        return "allOrdersPage";
    }

    @GetMapping("/add")
    public String showAddOrderPage(Model model) {
        List<Medicament> allMedicaments = medicamentRepository.findAll();
        model.addAttribute("medicaments", allMedicaments);
        model.addAttribute("order", new Order());
        return "addOrderPage";
    }

    @PostMapping("/save")
    public String saveOrder(@ModelAttribute Order order, Model model) {
        orderService.saveOrder(order);
        Long id = order.getId();
        String message = "Record with id: '" + id + "' is saved successfully!";
        model.addAttribute("message", message);
        return "addOrderPage";
    }
        @PostMapping("/create")
        public String createOrderFromMedicament(@RequestParam Long medicamentId, Model model) {
            Medicament medicament = medicamentRepository.findById(medicamentId).orElse(null);

            if (medicament != null) {
                Order order = orderService.findOrderByMedicament(medicament);

                if (order == null) {
                    order = new Order();
                }

                OrderItem orderItem = new OrderItem();
                orderItem.setMedicament(medicament);
                orderItem.setQuantity(1);

                order.getItems().add(orderItem);
                orderService.saveOrder(order);

                String message = "Order created successfully with medicament: " + medicament.getNom();
                model.addAttribute("message", message);
            } else {
                model.addAttribute("message", "Failed to create order. Medicament not found.");
            }

            return "redirect:/orders/add";
        }

    }

 */

