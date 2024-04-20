package com.hexagonal.architecture.domain.dto;

import com.hexagonal.architecture.domain.Product;

public record ProductDTO(
        String name,
        String description,
        Double price,
        int amount
) {

    public Product toProduct() {
        return new Product(
                null,
                name,
                description,
                price,
                amount
        );
    }
}
