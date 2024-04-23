package com.hexagonal.adapter.web.dto;

import com.hexagonal.adapter.web.dto.utils.BaseRequestPostDTO;
import com.hexagonal.domain.command.RegisterAuthor;
import com.hexagonal.domain.enums.GenreEnum;
import com.hexagonal.domain.valueobjects.AuthorRegistration;
import com.hexagonal.domain.valueobjects.FullName;

public record CreateAuthorRequestDTO(
        String fullName,
        String authorRegistration,
        String genre
) implements BaseRequestPostDTO<RegisterAuthor> {

    @Override
    public RegisterAuthor toDomain() {
        return new RegisterAuthor(
                FullName.from(fullName),
                AuthorRegistration.from(authorRegistration),
                GenreEnum.valueOf(genre)
        );
    }
}
