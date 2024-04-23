package com.hexagonal.infraestructure.repositories;

import com.hexagonal.infraestructure.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountInfraJpaRepository extends JpaRepository<AccountEntity, UUID> {
}
