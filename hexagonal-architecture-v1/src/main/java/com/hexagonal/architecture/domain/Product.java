package com.hexagonal.architecture.domain;

import com.hexagonal.architecture.domain.dto.ProductDTO;

import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private String description;
    private Double price;
    private int amount;

    public Product() {
    }

    public Product(
            UUID id,
            String name,
            String description,
            Double price,
            int amount
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public Product(ProductDTO productDTO) {
        this.name = productDTO.name();
        this.description = productDTO.description();
        this.price = productDTO.price();
        this.amount = productDTO.amount();
    }


}
