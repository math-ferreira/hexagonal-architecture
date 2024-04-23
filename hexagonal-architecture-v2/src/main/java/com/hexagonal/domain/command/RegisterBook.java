package com.hexagonal.domain.command;

import com.hexagonal.domain.valueobjects.ISBN;
import com.hexagonal.domain.valueobjects.Price;
import com.hexagonal.domain.valueobjects.PublicationDate;
import com.hexagonal.domain.valueobjects.StockQuantity;

public record RegisterBook(
        ISBN isbn,
        String title,
        RegisterAuthor registerAuthor,
        PublicationDate publicationDate,
        Price price,
        StockQuantity stockQuantity
) {
}
