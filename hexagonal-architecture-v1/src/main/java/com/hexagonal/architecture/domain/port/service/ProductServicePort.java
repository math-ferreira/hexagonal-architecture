package com.hexagonal.architecture.domain.port.service;

import com.hexagonal.architecture.domain.dto.ProductDTO;

import java.util.List;
import java.util.UUID;

public interface ProductServicePort {

    List<ProductDTO> getProducts();

    void createProduct(ProductDTO productDTO);

    void updateProduct(UUID id, ProductDTO productDTO);
}
