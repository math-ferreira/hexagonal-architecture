package com.hexagonal.application.repositories;

import com.hexagonal.domain.model.Account;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository {

    Optional<Account> findById(UUID accountId);

    void save(Account account);
}
