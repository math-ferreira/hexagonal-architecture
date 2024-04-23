package com.hexagonal.application.service;

import com.hexagonal.application.repositories.BookRepository;
import com.hexagonal.application.usecases.BookUseCase;
import com.hexagonal.domain.command.RegisterAuthor;
import com.hexagonal.domain.command.RegisterBook;
import com.hexagonal.domain.model.Book;
import com.hexagonal.domain.enums.GenreEnum;
import com.hexagonal.domain.valueobjects.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    @Test
    @DisplayName("Test getAllBooks method")
    public void testGetAllBooks() {
        BookRepository bookRepository = mock(BookRepository.class);
        List<Book> mockBooks = new ArrayList<>();

        RegisterBook registerBook = new RegisterBook(
                new ISBN("1234567890123"),
                "Title",
                new RegisterAuthor(new FullName("John Doe"), new AuthorRegistration("AR4567"), GenreEnum.MALE),
                new PublicationDate(LocalDate.now().minusMonths(5)),
                new Price(10.99),
                new StockQuantity(10)
        );

        var book = Book.registerBy(registerBook);

        mockBooks.add(book);
        when(bookRepository.findAll()).thenReturn(mockBooks);
        BookUseCase bookService = new BookService(bookRepository);

        List<Book> result = bookService.getAllBooks();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("Test registerBook method with valid input")
    public void testRegisterBook() {
        BookRepository bookRepository = mock(BookRepository.class);
        BookUseCase bookService = new BookService(bookRepository);
        RegisterBook registerBook = new RegisterBook(
                new ISBN("1234567890123"),
                "Title",
                new RegisterAuthor(new FullName("John Doe"), new AuthorRegistration("AR1234"), GenreEnum.MALE),
                new PublicationDate(LocalDate.now().minusDays(1)),
                new Price(10.99),
                new StockQuantity(10)
        );
        when(bookRepository.findByIsbn(any(ISBN.class))).thenReturn(Optional.empty());

        Book result = bookService.registerBook(registerBook);

        assertNotNull(result);
    }

    @Test
    @DisplayName("Test registerBook method with invalid input")
    public void testRegisterBookInvalidInput() {
        BookRepository bookRepository = mock(BookRepository.class);
        BookUseCase bookService = new BookService(bookRepository);
        RegisterBook registerBook = null;

        assertThrows(IllegalArgumentException.class, () -> {
            bookService.registerBook(registerBook);
        });
    }
}

