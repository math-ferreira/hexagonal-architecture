package com.hexagonal.domain.command;

import com.hexagonal.domain.valueobjects.UserProfile;

public record RegisterAccount(
        UserProfile userProfile
) {
}
