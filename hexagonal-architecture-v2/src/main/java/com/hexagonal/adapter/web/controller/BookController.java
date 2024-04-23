package com.hexagonal.adapter.web.controller;

import com.hexagonal.adapter.web.dto.BookResponseDTO;
import com.hexagonal.adapter.web.dto.CreateBookRequestDTO;
import com.hexagonal.adapter.web.dto.ModifyBookRequestDTO;
import com.hexagonal.application.usecases.BookUseCase;
import com.hexagonal.domain.command.ModifyBook;
import com.hexagonal.domain.command.RegisterBook;
import com.hexagonal.domain.model.Book;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/book")
@Tag(name = "Book controller")
public class BookController {

    private final BookUseCase bookUseCase;

    public BookController(BookUseCase bookUseCase) {
        this.bookUseCase = bookUseCase;
    }
    @GetMapping
    @Operation(summary = "Get the list of Books")
    @ApiResponses(value = {@ApiResponse(responseCode = "200")})
    public ResponseEntity<List<BookResponseDTO>> getBooks() {
        final List<Book> bookList = bookUseCase.getAllBooks();
        return ResponseEntity.ok(BookResponseDTO.fromDomain(bookList));
    }

    @PostMapping
    @Operation(summary = "Register a new Book")
    @ApiResponses(value = {@ApiResponse(responseCode = "200")})
    public ResponseEntity<BookResponseDTO> registerBook(@RequestBody CreateBookRequestDTO createBookRequestDTO) {
        final RegisterBook registerBook = createBookRequestDTO.toDomain();
        final Book book = bookUseCase.registerBook(registerBook);
        return ResponseEntity.ok(BookResponseDTO.fromDomain(book));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a Book by ID")
    @ApiResponses(value = {@ApiResponse(responseCode = "200")})
    public ResponseEntity<BookResponseDTO> updateBook(
            @PathVariable UUID id,
            @RequestBody ModifyBookRequestDTO modifyBookRequestDTO
    ) {
        final ModifyBook modifyBook = modifyBookRequestDTO.toDomain(id);
        final Book book = bookUseCase.modifyBook(modifyBook);
        return ResponseEntity.ok(BookResponseDTO.fromDomain(book));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Book by ID")
    @ApiResponses(value = {@ApiResponse(responseCode = "204")})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<BookResponseDTO> updateBook(@PathVariable UUID id) {
        bookUseCase.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

}
