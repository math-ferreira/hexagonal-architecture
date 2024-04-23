package com.hexagonal.application.service;

import com.hexagonal.application.usecases.ExchangeBookUseCase;
import com.hexagonal.domain.model.Book;
import com.hexagonal.domain.valueobjects.Currency;
import com.hexagonal.domain.valueobjects.ExchangeBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class ExchangeService implements ExchangeBookUseCase {

    private final BookService bookService;

    public ExchangeService(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public ExchangeBook calculateExchangeBook(UUID bookId, Currency currency) {
        final Book book = bookService.findBookOrThrowException(bookId);

        final double exchangePriceByCurrency = book.exchangePriceByCurrency(currency);
        final double totalExchangeByCurrency = book.calculateTotalExchangeByCurrency(currency);

        final ExchangeBook exchangeBook = new ExchangeBook(
                bookId,
                exchangePriceByCurrency,
                totalExchangeByCurrency
        );

        log.info("Exchange rate calculated successfully: {}", bookId);

        return exchangeBook;
    }
}
