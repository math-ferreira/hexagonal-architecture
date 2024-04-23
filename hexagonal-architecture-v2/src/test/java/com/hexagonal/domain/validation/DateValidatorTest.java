package com.hexagonal.domain.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Date Validator Test")
public class DateValidatorTest {

    @Test
    @DisplayName("Test isPastDate method with past and future dates")
    public void testIsPastDate() {
        LocalDate pastDate = LocalDate.now().minusDays(1);
        assertTrue(DateValidator.isPastDate(pastDate));

        LocalDate futureDate = LocalDate.now().plusDays(1);
        assertFalse(DateValidator.isPastDate(futureDate));
    }

    @Test
    @DisplayName("Test isFutureDate method with future and past dates")
    public void testIsFutureDate() {
        LocalDate futureDate = LocalDate.now().plusDays(1);
        assertTrue(DateValidator.isFutureDate(futureDate));

        LocalDate pastDate = LocalDate.now().minusDays(1);
        assertFalse(DateValidator.isFutureDate(pastDate));
    }

    @Test
    @DisplayName("Test isToday method with current, past, and future dates")
    public void testIsToday() {
        LocalDate currentDate = LocalDate.now();
        assertTrue(DateValidator.isToday(currentDate));

        LocalDate pastDate = LocalDate.now().minusDays(1);
        assertFalse(DateValidator.isToday(pastDate));

        LocalDate futureDate = LocalDate.now().plusDays(1);
        assertFalse(DateValidator.isToday(futureDate));
    }
}
