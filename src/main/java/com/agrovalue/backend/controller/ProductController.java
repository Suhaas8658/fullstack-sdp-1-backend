package com.agrovalue.backend.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.agrovalue.backend.model.Product;
import com.agrovalue.backend.model.User;
import com.agrovalue.backend.repository.ProductRepository;
import com.agrovalue.backend.repository.UserRepository;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private UserRepository userRepo;

    @PostMapping
    public Product createProduct(@RequestParam Long farmerId, @RequestBody Product product) {
        User farmer = userRepo.findById(farmerId)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));

        product.setFarmer(farmer);
        return productRepo.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
}