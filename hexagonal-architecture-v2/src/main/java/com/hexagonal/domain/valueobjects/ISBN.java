package com.hexagonal.domain.valueobjects;

import com.hexagonal.domain.valueobjects.exceptions.InvalidFormatException;

import java.util.Objects;

public record ISBN(
        String value
) {
    private static final int ISBN_NUMBER_OF_DIGITS = 13;
    private static final String ONLY_NUMBERS = "[0-9]+";

    /**
     * @throws InvalidFormatException
     */
    public ISBN {
        validateISBNValue(value);
    }

    public String getISBNFormatted() {
        return String.format(
                "ISBN-13 %s-%s-%s-%s-%s",
                this.value.substring(0, 3),
                this.value.substring(3, 4),
                this.value.substring(4, 10),
                this.value.substring(10, 12),
                this.value.substring(12)
        );
    }

    public static ISBN from(String isbn) {
        return new ISBN(isbn);
    }

    private void validateISBNValue(String value) throws InvalidFormatException {
        if (!value.matches(ONLY_NUMBERS) || value.length() != ISBN_NUMBER_OF_DIGITS)
            throw new InvalidFormatException(value, this.getClass());
    }

    @Override
    public String toString() {
        return getISBNFormatted();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ISBN otherISBN = (ISBN) obj;
        return Objects.equals(value, otherISBN.value);
    }

}
