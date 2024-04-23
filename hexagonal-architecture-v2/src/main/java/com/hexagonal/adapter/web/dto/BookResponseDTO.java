package com.hexagonal.adapter.web.dto;

import com.hexagonal.adapter.web.dto.utils.BaseResponseDTO;
import com.hexagonal.domain.model.Book;

import java.util.List;
import java.util.UUID;

public record BookResponseDTO(
        UUID bookId,
        String isbn,
        String title,
        String authorFullName,
        String publicationDate,
        double price,
        String currency,
        int stockQuantity

) implements BaseResponseDTO {

    public static BookResponseDTO fromDomain(Book book) {
        return new BookResponseDTO(
                book.getBookId(),
                book.getIsbn().getISBNFormatted(),
                book.getTitle(),
                book.getAuthor().getFullName().value(),
                book.getPublicationDate().getPublicationDateFormatted(),
                book.getPrice().value(),
                book.getCurrency().currencyEnum().getCurrencyName(),
                book.getStockQuantity().value()
        );
    }

    public static List<BookResponseDTO> fromDomain(List<Book> books) {
        return books.stream().map(BookResponseDTO::fromDomain).toList();
    }

}
