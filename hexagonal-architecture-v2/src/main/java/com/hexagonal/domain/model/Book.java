package com.hexagonal.domain.model;

import com.hexagonal.domain.command.ModifyBook;
import com.hexagonal.domain.command.RegisterBook;
import com.hexagonal.domain.enums.CurrencyEnum;
import com.hexagonal.domain.valueobjects.*;

import java.util.Objects;
import java.util.UUID;

public class Book {
    private final UUID bookId;
    private final ISBN isbn;
    private String title;
    private Author author;
    private PublicationDate publicationDate;
    private Price price;
    private final Currency currency;
    private StockQuantity stockQuantity;

    private Book(
            UUID bookId,
            ISBN isbn,
            String title,
            Author author,
            PublicationDate publicationDate,
            Price price,
            Currency currency,
            StockQuantity stockQuantity
    ) {

        Objects.requireNonNull(bookId);
        Objects.requireNonNull(isbn);
        Objects.requireNonNull(title);
        Objects.requireNonNull(author);
        Objects.requireNonNull(publicationDate);
        Objects.requireNonNull(price);
        Objects.requireNonNull(currency);
        Objects.requireNonNull(stockQuantity);

        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.price = price;
        this.currency = currency;
        this.stockQuantity = stockQuantity;
    }

    public static Book from(
            final UUID bookId,
            final ISBN isbn,
            final String title,
            final Author author,
            final PublicationDate publicationDate,
            final Price price,
            final Currency currency,
            final StockQuantity stockQuantity
    ) {
        return new Book(
                bookId,
                isbn,
                title,
                author,
                publicationDate,
                price,
                currency,
                stockQuantity
        );
    }

    public static Book registerBy(final RegisterBook registerBook) {
        if (registerBook == null) throw new IllegalArgumentException("RegisterBook cannot be null");

        if (registerBook.registerAuthor() == null) throw new IllegalArgumentException("RegisterAuthor cannot be null");

        var bookId = generateId();

        final Author author = Author.registerBy(registerBook.registerAuthor());

        return new Book(
                bookId,
                registerBook.isbn(),
                registerBook.title(),
                author,
                registerBook.publicationDate(),
                registerBook.price(),
                new Currency(CurrencyEnum.EURO),
                registerBook.stockQuantity()
        );
    }

    public Book changeBy(final ModifyBook modifyBook) {

        if (modifyBook == null) throw new IllegalArgumentException("ModifyBook cannot be null");

        this.title = modifyBook.title();
        this.price = modifyBook.price();
        this.stockQuantity = modifyBook.stockQuantity();

        return this;
    }

    private static UUID generateId() {
        return UUID.randomUUID();
    }

    public double calculateTotalPriceOnStock() {
        return this.price.value() * this.stockQuantity.value();
    }

    public double exchangePriceByCurrency(Currency toCurrency) {
        return this.price.value() * toCurrency.currencyEnum().getExchangeRateFromEuro();
    }

    public double calculateTotalExchangeByCurrency(Currency toCurrency) {
        return this.price.value() * this.stockQuantity.value() * toCurrency.currencyEnum().getExchangeRateFromEuro();
    }

    public boolean isAvailable() {
        return this.stockQuantity.value() > 0;
    }

    public UUID getBookId() {
        return bookId;
    }

    public ISBN getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public PublicationDate getPublicationDate() {
        return publicationDate;
    }

    public Price getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public StockQuantity getStockQuantity() {
        return stockQuantity;
    }
}
