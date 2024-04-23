package com.hexagonal.domain.model;

import com.hexagonal.domain.command.ModifyAccount;
import com.hexagonal.domain.command.RegisterAccount;
import com.hexagonal.domain.enums.AccountStatusEnum;
import com.hexagonal.domain.valueobjects.UserProfile;

import java.util.Objects;
import java.util.UUID;

public class Account {
    private final UUID accountId;
    private AccountStatusEnum accountStatus;
    private UserProfile userProfile;

    private Account(
            UUID accountId,
            AccountStatusEnum accountStatus,
            UserProfile userProfile
    ) {

        Objects.requireNonNull(accountId);
        Objects.requireNonNull(accountStatus);
        Objects.requireNonNull(userProfile);

        this.accountId = accountId;
        this.accountStatus = accountStatus;
        this.userProfile = userProfile;
    }

    public static Account from(
            UUID accountId,
            AccountStatusEnum accountStatus,
            UserProfile userProfile
    ) {
        return new Account(
                accountId,
                accountStatus,
                userProfile
        );
    }

    public static Account registerBy(final RegisterAccount registerAccount) {
        if (registerAccount == null) throw new IllegalArgumentException("RegisterAccount cannot be null");

        var bookId = generateId();

        return new Account(
                bookId,
                AccountStatusEnum.ACTIVE,
                registerAccount.userProfile()
        );
    }

    public Account changeBy(final ModifyAccount modifyAccount) {

        if (modifyAccount == null) throw new IllegalArgumentException("ModifyAccount cannot be null");

        this.accountStatus = modifyAccount.accountStatus();
        this.userProfile = modifyAccount.userProfile();

        return this;
    }

    private static UUID generateId() {
        return UUID.randomUUID();
    }

    public boolean isActiveAccount() {
        return this.accountStatus.equals(AccountStatusEnum.ACTIVE);
    }

    public UUID getAccountId() {
        return accountId;
    }

    public AccountStatusEnum getAccountStatus() {
        return accountStatus;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }


}
