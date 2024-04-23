package com.hexagonal.adapter.web.controller;

import com.hexagonal.adapter.web.dto.ExchangeRateResponseDTO;
import com.hexagonal.application.usecases.ExchangeBookUseCase;
import com.hexagonal.domain.valueobjects.Currency;
import com.hexagonal.domain.valueobjects.ExchangeBook;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/exchange")
@Tag(name = "Exchange controller")
public class ExchangeController {

    private final ExchangeBookUseCase exchangeBookUseCase;

    public ExchangeController(ExchangeBookUseCase exchangeBookUseCase) {
        this.exchangeBookUseCase = exchangeBookUseCase;
    }

    @GetMapping("/{id}/currency/{currency}")
    @Operation(summary = "Get the Book exchange rate from Currency")
    @ApiResponses(value = {@ApiResponse(responseCode = "200")})
    public ResponseEntity<ExchangeRateResponseDTO> getExchangeRates(
            @PathVariable UUID id,
            @PathVariable String currency
    ) {
        final ExchangeBook exchangeBook = exchangeBookUseCase.calculateExchangeBook(id, Currency.from(currency));
        return ResponseEntity.ok(ExchangeRateResponseDTO.fromDomain(exchangeBook));
    }

}
