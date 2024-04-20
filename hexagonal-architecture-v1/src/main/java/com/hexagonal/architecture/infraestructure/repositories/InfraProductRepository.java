package com.hexagonal.architecture.infraestructure.repositories;

import com.hexagonal.architecture.infraestructure.adapters.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InfraProductRepository extends JpaRepository<ProductEntity, UUID> {
}
