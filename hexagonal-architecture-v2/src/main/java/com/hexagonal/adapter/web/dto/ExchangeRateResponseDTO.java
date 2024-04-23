package com.hexagonal.adapter.web.dto;

import com.hexagonal.adapter.web.dto.utils.BaseResponseDTO;
import com.hexagonal.domain.valueobjects.ExchangeBook;

public record ExchangeRateResponseDTO(
        double exchangePrice,
        double totalExchange

) implements BaseResponseDTO {

    public static ExchangeRateResponseDTO fromDomain(ExchangeBook exchangeBook) {
        return new ExchangeRateResponseDTO(
                exchangeBook.exchangePrice(),
                exchangeBook.totalExchange()
        );
    }

}
