package com.hexagonal.domain.model;

import com.hexagonal.domain.valueobjects.FullName;

import java.util.Objects;
import java.util.UUID;

public class Customer {
    private final UUID customerId;
    private final FullName fullName;
    private final Account account;

    private Customer(
            UUID customerId,
            FullName fullName,
            Account account
    ) {

        Objects.requireNonNull(customerId);
        Objects.requireNonNull(fullName);
        Objects.requireNonNull(account);

        this.customerId = customerId;
        this.fullName = fullName;
        this.account = account;
    }

    public static Customer from(
            UUID customerId,
            FullName fullName,
            Account account
    ) {
        return new Customer(customerId, fullName, account);
    }

    private UUID generateId() {
        return UUID.randomUUID();
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public FullName getFullName() {
        return fullName;
    }

    public Account getAccount() {
        return account;
    }
}
