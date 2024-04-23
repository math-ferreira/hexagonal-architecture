package com.hexagonal.domain.validation;

import java.time.LocalDate;

public record DateValidator() {
    public static boolean isPastDate(LocalDate date) {
        LocalDate currentDate = LocalDate.now();
        return date.isBefore(currentDate);
    }

    public static boolean isFutureDate(LocalDate date) {
        LocalDate currentDate = LocalDate.now();
        return date.isAfter(currentDate);
    }

    public static boolean isToday(LocalDate date) {
        LocalDate currentDate = LocalDate.now();
        return date.isEqual(currentDate);
    }
}
