package com.hexagonal.adapter.persistence.mapper;

import com.hexagonal.domain.enums.GenreEnum;
import com.hexagonal.domain.model.Author;
import com.hexagonal.domain.valueobjects.AuthorRegistration;
import com.hexagonal.domain.valueobjects.FullName;
import com.hexagonal.infraestructure.entities.AuthorEntity;
import com.hexagonal.infraestructure.entities.enums.GenreInfraEnum;

public record AuthorMapper() {

    public static Author toDomain(AuthorEntity authorEntity) {
        return Author.from(
                authorEntity.getId(),
                new FullName(authorEntity.getFullName()),
                new AuthorRegistration(authorEntity.getAuthorRegistration()),
                GenreEnum.valueOf(authorEntity.getGenre().name())
        );
    }

    public static AuthorEntity toEntity(Author author) {
        return new AuthorEntity(
                author.getAuthorId(),
                author.getFullName().value(),
                author.getAuthorRegistration().value(),
                GenreInfraEnum.valueOf(author.getGenre().name()),
                null,
                null
        );
    }

}
