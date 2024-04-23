package com.hexagonal.application.exceptions;

public class BookNotFoundException extends BaseException {

    public BookNotFoundException(String message, String value) {
        super(message, message);
    }
}
