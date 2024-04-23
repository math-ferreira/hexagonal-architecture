package com.hexagonal.domain.valueobjects;

import com.hexagonal.domain.valueobjects.exceptions.InvalidFormatException;

import java.util.Objects;


public record Price(
        double value
) {

    /**
     * @throws InvalidFormatException
     */
    public Price {
        validatePrice(value);
    }

    private void validatePrice(double value) throws InvalidFormatException {
        if (value < 0) throw new InvalidFormatException(String.valueOf(value), this.getClass());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Price otherISBN = (Price) obj;
        return Objects.equals(value, otherISBN.value);
    }

}
