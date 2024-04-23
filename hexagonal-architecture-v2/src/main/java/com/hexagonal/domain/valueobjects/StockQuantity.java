package com.hexagonal.domain.valueobjects;

import com.hexagonal.domain.valueobjects.exceptions.InvalidFormatException;

import java.util.Objects;

public record StockQuantity(
        int value
) {

    /**
     * @throws InvalidFormatException
     */
    public StockQuantity {
        validateStockQuantity(value);
    }

    private void validateStockQuantity(int value) throws InvalidFormatException {
        if (value < 0) throw new InvalidFormatException(String.valueOf(value), this.getClass());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        StockQuantity otherStockQuantity = (StockQuantity) obj;
        return Objects.equals(value, otherStockQuantity.value);
    }

}
