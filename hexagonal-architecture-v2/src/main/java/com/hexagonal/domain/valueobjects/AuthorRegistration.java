package com.hexagonal.domain.valueobjects;

import com.hexagonal.domain.valueobjects.exceptions.InvalidFormatException;

import java.util.Objects;

public record AuthorRegistration(
        String value
) {
    private static final int REGISTRATION_NUMBER_OF_DIGITS = 6;

    /**
     * @throws InvalidFormatException
     */
    public AuthorRegistration {
        validateRegistrationNumberValue(value);
    }

    private void validateRegistrationNumberValue(String value) throws InvalidFormatException {
        if (value.length() != REGISTRATION_NUMBER_OF_DIGITS || !value.startsWith("AR"))
            throw new InvalidFormatException(value, this.getClass());
    }

    public static AuthorRegistration from(String value) {
        return new AuthorRegistration(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AuthorRegistration otherAuthorRegistration = (AuthorRegistration) obj;
        return Objects.equals(value, otherAuthorRegistration.value);
    }

}
