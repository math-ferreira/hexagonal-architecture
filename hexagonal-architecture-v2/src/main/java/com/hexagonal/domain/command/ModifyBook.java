package com.hexagonal.domain.command;

import com.hexagonal.domain.valueobjects.Price;
import com.hexagonal.domain.valueobjects.StockQuantity;

import java.util.UUID;

public record ModifyBook(

        UUID bookId,
        String title,
        Price price,
        StockQuantity stockQuantity
) {
}
