package com.hexagonal.application.exceptions;

public class InvalidBookException extends BaseException {

    public InvalidBookException(String message, String value) {
        super(message, value);
    }
}
