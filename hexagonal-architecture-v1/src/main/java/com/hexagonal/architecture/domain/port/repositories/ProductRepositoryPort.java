package com.hexagonal.architecture.domain.port.repositories;

import com.hexagonal.architecture.domain.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepositoryPort {
    void save(Product product);
    void update(UUID id, Product product);
    Optional<Product> findById(UUID id);
    List<Product> findAll();
}
