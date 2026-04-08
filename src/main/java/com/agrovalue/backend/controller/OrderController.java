package com.agrovalue.backend.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.agrovalue.backend.model.Order;
import com.agrovalue.backend.model.Product;
import com.agrovalue.backend.model.User;
import com.agrovalue.backend.repository.OrderRepository;
import com.agrovalue.backend.repository.ProductRepository;
import com.agrovalue.backend.repository.UserRepository;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private UserRepository userRepo;

    @PostMapping
    public Order createOrder(
            @RequestParam Long buyerId,
            @RequestParam Long productId,
            @RequestParam int quantity
    ) {
        User buyer = userRepo.findById(buyerId)
                .orElseThrow(() -> new RuntimeException("Buyer not found"));

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Order order = new Order();
        order.setBuyer(buyer);
        order.setProduct(product);
        order.setQuantity(quantity);
        order.setTotalPrice(product.getPricePerUnit() * quantity);
        order.setCreatedAt(LocalDateTime.now());

        return orderRepo.save(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
}