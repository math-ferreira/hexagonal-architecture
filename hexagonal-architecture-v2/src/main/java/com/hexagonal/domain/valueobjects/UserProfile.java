package com.hexagonal.domain.valueobjects;

public record UserProfile(
        Username username,
        Password password
) {

    public static UserProfile from(String username, String password) {
        return new UserProfile(
                new Username(username),
                new Password(password)
        );
    }

}
