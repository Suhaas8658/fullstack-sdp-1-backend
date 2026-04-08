package com.agrovalue.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;
    private double totalPrice;
    private LocalDateTime createdAt;

    @ManyToOne
    private User buyer;

    @ManyToOne
    private Product product;

    // getters & setters

    public Long getId() { return id; }

    public int getQuantity() { return quantity; }
    public double getTotalPrice() { return totalPrice; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public User getBuyer() { return buyer; }
    public Product getProduct() { return product; }

    public void setId(Long id) { this.id = id; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setBuyer(User buyer) { this.buyer = buyer; }
    public void setProduct(Product product) { this.product = product; }
}