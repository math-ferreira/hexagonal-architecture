package com.hexagonal.domain.valueobjects;

import com.hexagonal.domain.valueobjects.exceptions.InvalidFormatException;

public record FullName(
        String value
) {

    public FullName {
        validateFullName(value);
    }

    private void validateFullName(String value) throws InvalidFormatException {
        if (value == null || value.isBlank() || !value.contains(" "))
            throw new InvalidFormatException(value, this.getClass());
    }

    public static FullName from(String fullName) {
        return new FullName(fullName);
    }
}
