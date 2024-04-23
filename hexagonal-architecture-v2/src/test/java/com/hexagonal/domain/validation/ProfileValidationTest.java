package com.hexagonal.domain.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Profile Validator Test")
public class ProfileValidationTest {

    @Test
    @DisplayName("Test isInvalidPassword method with valid and invalid passwords")
    public void testIsInvalidPassword() {
        assertFalse(ProfileValidation.isInvalidPassword("validPassword"));
        assertFalse(ProfileValidation.isInvalidPassword("12345678"));
        assertFalse(ProfileValidation.isInvalidPassword("aBcDefG1"));

        assertTrue(ProfileValidation.isInvalidPassword("short"));
        assertTrue(ProfileValidation.isInvalidPassword("thisIsAVeryVeryLongPassword1234567890"));
        assertTrue(ProfileValidation.isInvalidPassword("1234566666"));
    }

    @Test
    @DisplayName("Test isInvalidUsername method with valid and invalid usernames")
    public void testIsInvalidUsername() {
        assertFalse(ProfileValidation.isInvalidUsername("validUsername"));
        assertFalse(ProfileValidation.isInvalidUsername("thisIsMyUsername"));

        assertTrue(ProfileValidation.isInvalidUsername("short"));
        assertTrue(ProfileValidation.isInvalidUsername("thisIsAVeryVeryLongUsername123456"));
        assertTrue(ProfileValidation.isInvalidUsername("username1234"));
    }
}

