package com.hexagonal.adapter.web.dto;

import com.hexagonal.adapter.web.dto.utils.BaseRequestPutDTO;
import com.hexagonal.domain.command.ModifyBook;
import com.hexagonal.domain.valueobjects.Price;
import com.hexagonal.domain.valueobjects.StockQuantity;

import java.util.UUID;

public record ModifyBookRequestDTO(
        String title,
        CreateAuthorRequestDTO author,
        double price,
        String currency,
        int stockQuantity
) implements BaseRequestPutDTO<ModifyBook> {

    @Override
    public ModifyBook toDomain(UUID bookId) {
        return new ModifyBook(
                bookId,
                title,
                new Price(price),
                new StockQuantity(stockQuantity)
        );
    }
}
