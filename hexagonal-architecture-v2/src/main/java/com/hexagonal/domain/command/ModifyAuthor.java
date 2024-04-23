package com.hexagonal.domain.command;

import com.hexagonal.domain.enums.GenreEnum;
import com.hexagonal.domain.valueobjects.AuthorRegistration;
import com.hexagonal.domain.valueobjects.FullName;

public record ModifyAuthor(
        FullName fullName,
        AuthorRegistration authorRegistration,
        GenreEnum genre
) {
}
