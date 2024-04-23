package com.hexagonal.application.exceptions;

public abstract class BaseException extends RuntimeException {

    private final String value;

    protected BaseException(String message, String value) {
        super(message);
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
