package com.hexagonal.domain.command;

import com.hexagonal.domain.enums.AccountStatusEnum;
import com.hexagonal.domain.valueobjects.UserProfile;

import java.util.UUID;

public record ModifyAccount(
        UUID accountId,
        AccountStatusEnum accountStatus,
        UserProfile userProfile
) {
}
