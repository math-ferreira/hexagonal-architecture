package com.hexagonal.adapter.persistence.mapper;

import com.hexagonal.domain.enums.CurrencyEnum;
import com.hexagonal.domain.model.Author;
import com.hexagonal.domain.model.Book;
import com.hexagonal.domain.valueobjects.*;
import com.hexagonal.infraestructure.entities.AuthorEntity;
import com.hexagonal.infraestructure.entities.BookEntity;
import com.hexagonal.infraestructure.entities.enums.CurrencyInfraEnum;

public record BookMapper() {

    public static Book toDomain(BookEntity bookEntity) {

        final ISBN isbn = new ISBN(bookEntity.getIsbn());
        final Author author = AuthorMapper.toDomain(bookEntity.getAuthor());
        final PublicationDate publicationDate = new PublicationDate(bookEntity.getPublicationDate());
        final Price price = new Price(bookEntity.getPrice());
        final Currency currency = new Currency(CurrencyEnum.valueOf(bookEntity.getCurrency().name()));
        final StockQuantity stockQuantity = new StockQuantity(bookEntity.getStockQuantity());

        return Book.from(
                bookEntity.getId(),
                isbn,
                bookEntity.getTitle(),
                author,
                publicationDate,
                price,
                currency,
                stockQuantity
        );
    }

    public static BookEntity toEntity(Book book) {

        final AuthorEntity authorEntity = AuthorMapper.toEntity(book.getAuthor());
        final CurrencyInfraEnum currencyInfraEnum = CurrencyInfraEnum.valueOf(book.getCurrency().currencyEnum().name());

        return new BookEntity(
                book.getBookId(),
                book.getIsbn().value(),
                book.getTitle(),
                authorEntity,
                book.getPublicationDate().value(),
                book.getPrice().value(),
                currencyInfraEnum,
                book.getStockQuantity().value(),
                null,
                null
        );
    }

}
