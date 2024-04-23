package com.hexagonal.adapter.web.dto;

import com.hexagonal.adapter.web.dto.utils.BaseRequestPostDTO;
import com.hexagonal.domain.command.RegisterAccount;
import com.hexagonal.domain.valueobjects.UserProfile;

public record CreateAccountRequestDTO(
        String username,
        String password
) implements BaseRequestPostDTO<RegisterAccount> {

    @Override
    public RegisterAccount toDomain() {
        return new RegisterAccount(
                UserProfile.from(username, password)
        );
    }
}
