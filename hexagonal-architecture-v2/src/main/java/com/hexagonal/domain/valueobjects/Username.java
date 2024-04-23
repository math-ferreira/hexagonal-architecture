package com.hexagonal.domain.valueobjects;

import com.hexagonal.domain.validation.ProfileValidation;
import com.hexagonal.domain.valueobjects.exceptions.InvalidFormatException;

import java.util.Objects;

public record Username(
        String value
) {

    /**
     * @throws InvalidFormatException
     */
    public Username {
        validateUsername(value);
    }

    private void validateUsername(String value) throws InvalidFormatException {
        if (ProfileValidation.isInvalidUsername(value))
            throw new InvalidFormatException(value, this.getClass());
    }

    @Override
    public String toString() {
        return String.format("%s*****", value.substring(0, 5));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Username otherUsername = (Username) obj;
        return Objects.equals(value, otherUsername.value);
    }

}
