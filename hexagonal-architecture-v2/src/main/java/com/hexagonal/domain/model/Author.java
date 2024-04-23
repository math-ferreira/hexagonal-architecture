package com.hexagonal.domain.model;

import com.hexagonal.domain.command.ModifyAuthor;
import com.hexagonal.domain.command.RegisterAuthor;
import com.hexagonal.domain.enums.GenreEnum;
import com.hexagonal.domain.valueobjects.AuthorRegistration;
import com.hexagonal.domain.valueobjects.FullName;

import java.util.Objects;
import java.util.UUID;

public class Author {
    private final UUID authorId;
    private FullName fullName;
    private AuthorRegistration authorRegistration;
    private GenreEnum genre;

    private Author(
            UUID authorId,
            FullName fullName,
            AuthorRegistration authorRegistration,
            GenreEnum genre
    ) {
        Objects.requireNonNull(authorId);
        Objects.requireNonNull(fullName);
        Objects.requireNonNull(authorRegistration);
        Objects.requireNonNull(genre);

        this.authorId = authorId;
        this.fullName = fullName;
        this.authorRegistration = authorRegistration;
        this.genre = genre;
    }

    public static Author from(
            UUID id,
            FullName fullName,
            AuthorRegistration authorRegistration,
            GenreEnum genre
    ) {
        return new Author(
                id,
                fullName,
                authorRegistration,
                genre
        );

    }

    public static Author registerBy(final RegisterAuthor registerAuthor) {
        if (registerAuthor == null) throw new IllegalArgumentException("RegisterAuthor cannot be null");

        var authorId = generateId();

        return new Author(
                authorId,
                registerAuthor.fullName(),
                registerAuthor.authorRegistration(),
                registerAuthor.genre()
        );
    }

    public Author changeBy(final ModifyAuthor modifyAuthor) {

        if (modifyAuthor == null) throw new IllegalArgumentException("ModifyAuthor cannot be null");

        this.authorRegistration = modifyAuthor.authorRegistration();
        this.fullName = modifyAuthor.fullName();
        this.genre = modifyAuthor.genre();

        return this;
    }

    private static UUID generateId() {
        return UUID.randomUUID();
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public FullName getFullName() {
        return fullName;
    }

    public AuthorRegistration getAuthorRegistration() {
        return authorRegistration;
    }

    public GenreEnum getGenre() {
        return genre;
    }
}
