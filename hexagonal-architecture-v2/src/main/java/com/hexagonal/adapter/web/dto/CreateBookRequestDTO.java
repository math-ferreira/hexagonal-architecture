package com.hexagonal.adapter.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hexagonal.adapter.web.dto.utils.BaseRequestPostDTO;
import com.hexagonal.domain.command.RegisterBook;
import com.hexagonal.domain.valueobjects.ISBN;
import com.hexagonal.domain.valueobjects.Price;
import com.hexagonal.domain.valueobjects.PublicationDate;
import com.hexagonal.domain.valueobjects.StockQuantity;

import java.time.LocalDate;

public record CreateBookRequestDTO(
        String isbn,
        String title,
        CreateAuthorRequestDTO author,
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate publicationDate,
        double price,
        String currency,
        int stockQuantity
) implements BaseRequestPostDTO<RegisterBook> {

    @Override
    public RegisterBook toDomain() {
        return new RegisterBook(
                ISBN.from(isbn),
                title,
                author.toDomain(),
                new PublicationDate(publicationDate),
                new Price(price),
                new StockQuantity(stockQuantity)
        );
    }
}
