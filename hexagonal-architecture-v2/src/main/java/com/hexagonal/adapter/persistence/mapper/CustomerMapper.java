package com.hexagonal.adapter.persistence.mapper;

import com.hexagonal.domain.model.Customer;
import com.hexagonal.domain.valueobjects.FullName;
import com.hexagonal.infraestructure.entities.CustomerEntity;

public record CustomerMapper() {

    public static Customer toDomain(CustomerEntity customerEntity) {

        return Customer.from(
                customerEntity.getId(),
                new FullName(customerEntity.getFullName()),
                AccountMapper.toDomain(customerEntity.getAccount())
        );
    }

    public static CustomerEntity toEntity(Customer customer) {

        return new CustomerEntity(
                customer.getCustomerId(),
                customer.getFullName().value(),
                AccountMapper.toEntity(customer.getAccount()),
                null,
                null
        );
    }

}
