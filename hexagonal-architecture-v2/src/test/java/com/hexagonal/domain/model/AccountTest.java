package com.hexagonal.domain.model;

import com.hexagonal.domain.command.ModifyAccount;
import com.hexagonal.domain.command.RegisterAccount;
import com.hexagonal.domain.enums.AccountStatusEnum;
import com.hexagonal.domain.valueobjects.Password;
import com.hexagonal.domain.valueobjects.UserProfile;
import com.hexagonal.domain.valueobjects.Username;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Account Test")
class AccountTest {

    @Test
    @DisplayName("should create Account successfully")
    void createAccountSuccessfully() {

        var expectedUserProfile = new UserProfile(
                new Username("john_doe_gunners"),
                new Password("password0101011")
        );
        var registerAccount = new RegisterAccount(expectedUserProfile);

        var account = Account.registerBy(registerAccount);

        assertThat(account.getAccountId()).isInstanceOf(UUID.class);
        assertThat(account.getAccountStatus()).isEqualTo(AccountStatusEnum.ACTIVE);
        assertThat(account.isActiveAccount()).isTrue();
        assertThat(account.getUserProfile()).isEqualTo(expectedUserProfile);
    }

    @Test
    @DisplayName("should modify account successfully")
    void modifyAccount() {

        var account = Account.registerBy(
                new RegisterAccount(
                        new UserProfile(
                                new Username("john_doe_old"),
                                new Password("password01010101")
                        )
                )
        );

        var updatedAccount = account.changeBy(
                new ModifyAccount(
                        account.getAccountId(),
                        AccountStatusEnum.BLOCKED,
                        new UserProfile(
                                new Username("john_doe_new"),
                                new Password("password02020202")
                        )
                )
        );

        assertThat(account.getAccountId()).isEqualTo(updatedAccount.getAccountId());
        assertThat(updatedAccount.getAccountStatus()).isEqualTo(AccountStatusEnum.BLOCKED);
        assertThat(account.getUserProfile().username().value()).isEqualTo("john_doe_new");
        assertThat(account.getUserProfile().password().value()).isEqualTo("password02020202");
    }

}
