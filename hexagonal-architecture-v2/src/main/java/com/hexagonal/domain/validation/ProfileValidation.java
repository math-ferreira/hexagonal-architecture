package com.hexagonal.domain.validation;

public record ProfileValidation() {

    private static final String REPEATABLE_PASSWORD_NUMBER_REGEX = "\\d*(\\d)\\1{2,}\\d*";
    private static final String CONTAINS_NUMBER_REGEX = ".*\\d.*";

    public static boolean isInvalidPassword(String password) {
        return (password.length() < 8)
                || (password.length() >= 30)
                || (password.matches(REPEATABLE_PASSWORD_NUMBER_REGEX));
    }

    public static boolean isInvalidUsername(String username) {
        return (username.length() < 10)
                || (username.length() >= 20)
                || (username.matches(CONTAINS_NUMBER_REGEX));
    }

}
