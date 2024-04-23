package com.hexagonal.domain.valueobjects;

import com.hexagonal.domain.validation.ProfileValidation;
import com.hexagonal.domain.valueobjects.exceptions.InvalidFormatException;

import java.util.Objects;

public record Password(
        String value
) {

    /**
     * @throws InvalidFormatException
     */
    public Password {
        validateRegistrationNumberValue(value);
    }

    private void validateRegistrationNumberValue(String value) throws InvalidFormatException {
        if (ProfileValidation.isInvalidPassword(value))
            throw new InvalidFormatException(value, this.getClass());
    }

    @Override
    public String toString() {
        return "********";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Password otherPassword = (Password) obj;
        return Objects.equals(value, otherPassword.value);
    }

}
