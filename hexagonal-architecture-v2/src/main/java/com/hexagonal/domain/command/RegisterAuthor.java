package com.hexagonal.domain.command;

import com.hexagonal.domain.enums.GenreEnum;
import com.hexagonal.domain.valueobjects.AuthorRegistration;
import com.hexagonal.domain.valueobjects.FullName;

public record RegisterAuthor(
        FullName fullName,
        AuthorRegistration authorRegistration,
        GenreEnum genre
) {
}
