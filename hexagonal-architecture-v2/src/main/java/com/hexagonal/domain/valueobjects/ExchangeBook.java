package com.hexagonal.domain.valueobjects;

import java.util.UUID;

public record ExchangeBook(
        UUID bookId,
        double exchangePrice,
        double totalExchange
) {

    public ExchangeBook {
        if (bookId == null || bookId.toString().isBlank()) throw new IllegalArgumentException("bookId cannot be null or empty");
        if (exchangePrice < 0) throw new IllegalArgumentException("exchangePrice cannot be less than zero");
        if (totalExchange < 0) throw new IllegalArgumentException("totalExchange cannot be less than zero");
    }

}
