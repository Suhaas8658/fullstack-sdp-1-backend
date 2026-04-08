package com.agrovalue.backend.model;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String baseCrop;
    private String valueAddedType;
    private String imageUrl;
    private double pricePerUnit;
    private int availableQuantity;

    @ManyToOne
    private User farmer;

    // getters & setters

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getBaseCrop() { return baseCrop; }
    public String getValueAddedType() { return valueAddedType; }
    public String getImageUrl() { return imageUrl; }
    public double getPricePerUnit() { return pricePerUnit; }
    public int getAvailableQuantity() { return availableQuantity; }
    public User getFarmer() { return farmer; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setBaseCrop(String baseCrop) { this.baseCrop = baseCrop; }
    public void setValueAddedType(String valueAddedType) { this.valueAddedType = valueAddedType; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setPricePerUnit(double pricePerUnit) { this.pricePerUnit = pricePerUnit; }
    public void setAvailableQuantity(int availableQuantity) { this.availableQuantity = availableQuantity; }
    public void setFarmer(User farmer) { this.farmer = farmer; }
}