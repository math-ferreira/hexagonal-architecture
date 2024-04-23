package com.hexagonal.adapter.persistence.mapper;

import com.hexagonal.domain.enums.AccountStatusEnum;
import com.hexagonal.domain.model.Account;
import com.hexagonal.domain.valueobjects.Password;
import com.hexagonal.domain.valueobjects.UserProfile;
import com.hexagonal.domain.valueobjects.Username;
import com.hexagonal.infraestructure.entities.AccountEntity;
import com.hexagonal.infraestructure.entities.enums.AccountStatusInfraEnum;

public record AccountMapper() {

    public static Account toDomain(AccountEntity accountEntity) {

        return Account.from(
                accountEntity.getId(),
                AccountStatusEnum.valueOf(accountEntity.getAccountStatus().name()),
                new UserProfile(
                        new Username(accountEntity.getUsername()),
                        new Password(accountEntity.getPassword())
                )
        );
    }

    public static AccountEntity toEntity(Account account) {

        return new AccountEntity(
                account.getAccountId(),
                AccountStatusInfraEnum.valueOf(account.getAccountStatus().name()),
                account.getUserProfile().username().value(),
                account.getUserProfile().password().value(),
                null,
                null

        );
    }

}
