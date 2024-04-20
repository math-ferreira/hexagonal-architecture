package com.hexagonal.architecture.infraestructure.config;

import com.hexagonal.architecture.domain.adapters.service.ProductServicePortImpl;
import com.hexagonal.architecture.domain.port.repositories.ProductRepositoryPort;
import com.hexagonal.architecture.domain.port.service.ProductServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    ProductServicePort productService(ProductRepositoryPort productRepositoryPort) {
        return new ProductServicePortImpl(productRepositoryPort);
    }

}
