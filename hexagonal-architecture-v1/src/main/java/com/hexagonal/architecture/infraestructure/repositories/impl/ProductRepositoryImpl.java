package com.hexagonal.architecture.infraestructure.repositories.impl;

import com.hexagonal.architecture.domain.Product;
import com.hexagonal.architecture.domain.port.repositories.ProductRepositoryPort;
import com.hexagonal.architecture.infraestructure.adapters.entities.ProductEntity;
import com.hexagonal.architecture.infraestructure.repositories.InfraProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ProductRepositoryImpl implements ProductRepositoryPort {

    private final InfraProductRepository infraProductRepository;

    public ProductRepositoryImpl(InfraProductRepository infraProductRepository) {
        this.infraProductRepository = infraProductRepository;
    }

    @Override
    public void save(Product product) {
        var productEntity = new ProductEntity(
                UUID.randomUUID(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getAmount()
        );
        infraProductRepository.save(productEntity);
    }

    @Override
    public void update(UUID id, Product product) {
        var productEntity = new ProductEntity(
                id,
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getAmount()
        );
        infraProductRepository.save(productEntity);
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return infraProductRepository.findById(id)
                .map(ProductEntity::toProduct);
    }

    @Override
    public List<Product> findAll() {
        return infraProductRepository.findAll()
                .stream().map(ProductEntity::toProduct)
                .toList();
    }
}
