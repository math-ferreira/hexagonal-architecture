package com.hexagonal.domain.valueobjects;

import com.hexagonal.domain.validation.DateValidator;
import com.hexagonal.domain.valueobjects.exceptions.InvalidFormatException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public record PublicationDate(
        LocalDate value
) {

    /**
     * @throws InvalidFormatException
     */
    public PublicationDate {
        validatePublicationDate(value);
    }

    private void validatePublicationDate(LocalDate value) throws InvalidFormatException {
        if (!DateValidator.isPastDate(value))
            throw new InvalidFormatException(value.toString(), this.getClass());
    }

    public String getPublicationDateFormatted() {
        return value.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PublicationDate otherPublicationDate = (PublicationDate) obj;
        return Objects.equals(value, otherPublicationDate.value);
    }

}
