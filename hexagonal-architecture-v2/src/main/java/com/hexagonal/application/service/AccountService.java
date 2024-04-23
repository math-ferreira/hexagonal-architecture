package com.hexagonal.application.service;

import com.hexagonal.application.exceptions.BookNotFoundException;
import com.hexagonal.application.repositories.AccountRepository;
import com.hexagonal.application.usecases.AccountUseCase;
import com.hexagonal.domain.command.ModifyAccount;
import com.hexagonal.domain.command.RegisterAccount;
import com.hexagonal.domain.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountService implements AccountUseCase {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account registerAccount(RegisterAccount registerAccount) {

        if (registerAccount == null) throw new IllegalArgumentException("RegisterAccount cannot be null");

        final Account account = Account.registerBy(registerAccount);
        accountRepository.save(account);

        log.info("New account registered successfully with the username: {}", registerAccount.userProfile().username());

        return account;
    }

    @Override
    public Account modifyAccount(ModifyAccount modifyAccount) {

        if (modifyAccount == null) throw new IllegalArgumentException("ModifyAccount cannot be null");

        final Account account = accountRepository.findById(modifyAccount.accountId())
                .orElseThrow(() -> new BookNotFoundException("Account was not found by Id", modifyAccount.accountId().toString()));

        final Account updatedAccount = account.changeBy(modifyAccount);

        log.info("An existing account was updated successfully with the ID: {}", modifyAccount.accountId());

        return updatedAccount;
    }
}
