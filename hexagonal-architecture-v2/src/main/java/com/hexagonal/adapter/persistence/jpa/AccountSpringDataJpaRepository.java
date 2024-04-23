package com.hexagonal.adapter.persistence.jpa;

import com.hexagonal.adapter.persistence.mapper.AccountMapper;
import com.hexagonal.application.repositories.AccountRepository;
import com.hexagonal.domain.model.Account;
import com.hexagonal.infraestructure.repositories.AccountInfraJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class AccountSpringDataJpaRepository implements AccountRepository {

    private final AccountInfraJpaRepository accountInfraJpaRepository;

    public AccountSpringDataJpaRepository(AccountInfraJpaRepository accountInfraJpaRepository) {
        this.accountInfraJpaRepository = accountInfraJpaRepository;
    }

    @Override
    public Optional<Account> findById(UUID accountId) {
        return accountInfraJpaRepository.findById(accountId)
                .map(AccountMapper::toDomain);
    }

    @Override
    public void save(Account account) {
        accountInfraJpaRepository.save(
                AccountMapper.toEntity(account)
        );
    }
}
