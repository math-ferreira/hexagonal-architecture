package com.hexagonal.domain.valueobjects.exceptions;

public class InvalidFormatException extends RuntimeException {

    private final String value;

    public InvalidFormatException(String value, Class<?> test) {
        super("Invalid format provided: " + value + ", class: " + test.getSimpleName());
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
