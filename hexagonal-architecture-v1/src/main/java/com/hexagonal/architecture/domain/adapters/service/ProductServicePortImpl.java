package com.hexagonal.architecture.domain.adapters.service;

import com.hexagonal.architecture.domain.Product;
import com.hexagonal.architecture.domain.dto.ProductDTO;
import com.hexagonal.architecture.domain.port.repositories.ProductRepositoryPort;
import com.hexagonal.architecture.domain.port.service.ProductServicePort;

import java.util.List;
import java.util.UUID;

public class ProductServicePortImpl implements ProductServicePort {

    private final ProductRepositoryPort productRepositoryPort;

    public ProductServicePortImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public List<ProductDTO> getProducts() {
        return this.productRepositoryPort.findAll().stream()
                .map(product -> new ProductDTO(
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getAmount())
                ).toList();
    }

    @Override
    public void createProduct(ProductDTO productDTO) {
        var product = new Product(productDTO);
        productRepositoryPort.save(product);
    }

    @Override
    public void updateProduct(UUID id, ProductDTO productDTO) {
        productRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Product was not found by ID"));

        productRepositoryPort.update(id, productDTO.toProduct());
    }
}
