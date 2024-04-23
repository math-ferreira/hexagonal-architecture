package com.hexagonal.adapter.web.handler;

import com.hexagonal.adapter.web.dto.ErrorResponseDTO;
import com.hexagonal.application.exceptions.BaseException;
import com.hexagonal.application.exceptions.BookNotFoundException;
import com.hexagonal.application.exceptions.InvalidBookException;
import com.hexagonal.domain.valueobjects.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ServiceExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> generalException(Exception exception) {
        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR.value())
                .body(ErrorResponseDTO.from(exception));
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<?> illegalArgumentException(IllegalArgumentException exception) {
        return ResponseEntity
                .status(BAD_REQUEST.value())
                .body(ErrorResponseDTO.from(exception));
    }

    @ExceptionHandler(value = InvalidFormatException.class)
    public ResponseEntity<?> invalidFormatException(InvalidFormatException exception) {
        return ResponseEntity
                .status(BAD_REQUEST.value())
                .body(ErrorResponseDTO.from(exception));
    }

    @ExceptionHandler(value = {BookNotFoundException.class, InvalidBookException.class})
    public ResponseEntity<?> badRequestException(BaseException exception) {
        return ResponseEntity
                .status(UNPROCESSABLE_ENTITY.value())
                .body(ErrorResponseDTO.from(exception));
    }

}

