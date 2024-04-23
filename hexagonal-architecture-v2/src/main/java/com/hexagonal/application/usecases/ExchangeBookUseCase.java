package com.hexagonal.application.usecases;

import com.hexagonal.domain.valueobjects.Currency;
import com.hexagonal.domain.valueobjects.ExchangeBook;

import java.util.UUID;

public interface ExchangeBookUseCase {

    ExchangeBook calculateExchangeBook(UUID bookId, Currency currency);

}
