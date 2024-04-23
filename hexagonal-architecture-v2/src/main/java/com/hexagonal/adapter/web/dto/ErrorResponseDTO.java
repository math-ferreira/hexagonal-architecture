package com.hexagonal.adapter.web.dto;

import com.hexagonal.application.exceptions.BaseException;
import com.hexagonal.domain.valueobjects.exceptions.InvalidFormatException;

public record ErrorResponseDTO(
        String field,
        String message
) {
    public static ErrorResponseDTO from(InvalidFormatException ex) {
        return new ErrorResponseDTO(
                ex.getValue(),
                ex.getMessage()
        );
    }

    public static ErrorResponseDTO from(BaseException ex) {
        return new ErrorResponseDTO(
                ex.getValue(),
                ex.getMessage()
        );
    }

    public static ErrorResponseDTO from(Exception ex) {
        return new ErrorResponseDTO(
                null,
                ex.getMessage()
        );
    }
}
