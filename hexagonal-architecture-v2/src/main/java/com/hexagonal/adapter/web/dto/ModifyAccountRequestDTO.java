package com.hexagonal.adapter.web.dto;

import com.hexagonal.adapter.web.dto.utils.BaseRequestPutDTO;
import com.hexagonal.domain.command.ModifyAccount;
import com.hexagonal.domain.enums.AccountStatusEnum;
import com.hexagonal.domain.valueobjects.UserProfile;

import java.util.UUID;

public record ModifyAccountRequestDTO(
        String username,
        String password,
        String status

) implements BaseRequestPutDTO<ModifyAccount> {

    @Override
    public ModifyAccount toDomain(UUID accountId) {
        return new ModifyAccount(
                accountId,
                AccountStatusEnum.valueOf(status),
                UserProfile.from(username, password)
        );
    }
}
