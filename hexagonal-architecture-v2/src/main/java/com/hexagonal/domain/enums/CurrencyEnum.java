package com.hexagonal.domain.enums;

public enum CurrencyEnum {

    EURO("Euro", "EUR", "€", 1),
    AMERICAN_DOLLAR("United States Dollar", "USD", "$", 1.07),
    REAL("Brazilian Real", "BRL", "R$", 5.5);

    private final String currencyName;
    private final String currencyInitials;
    private final String symbol;
    private final double exchangeRateFromEuro;

    CurrencyEnum(
            String currencyName,
            String currencyInitials,
            String symbol,
            double exchangeRateFromEuro
    ) {
        this.currencyName = currencyName;
        this.currencyInitials = currencyInitials;
        this.symbol = symbol;
        this.exchangeRateFromEuro = exchangeRateFromEuro;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getCurrencyInitials() {
        return currencyInitials;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getExchangeRateFromEuro() {
        return exchangeRateFromEuro;
    }
}
