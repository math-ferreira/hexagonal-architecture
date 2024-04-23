package com.hexagonal.domain.valueobjects;

import com.hexagonal.domain.enums.CurrencyEnum;

public record Currency(
        CurrencyEnum currencyEnum
) {

    public static Currency from(String value) {
        return new Currency(CurrencyEnum.valueOf(value));
    }

}
