package com.hexagonal.application.service;

import com.hexagonal.application.exceptions.BookNotFoundException;
import com.hexagonal.application.exceptions.InvalidBookException;
import com.hexagonal.application.repositories.BookRepository;
import com.hexagonal.application.usecases.BookUseCase;
import com.hexagonal.domain.command.ModifyBook;
import com.hexagonal.domain.command.RegisterBook;
import com.hexagonal.domain.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class BookService implements BookUseCase {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {

        final List<Book> bookList = bookRepository.findAll();

        log.info("List of Books retrieved successfully, size: {}", bookList.size());

        return bookList;
    }

    @Override
    public Book registerBook(RegisterBook registerBook) {

        if (registerBook == null) throw new IllegalArgumentException("RegisterBook cannot be null");

        final Optional<Book> optionalBook = bookRepository.findByIsbn(registerBook.isbn());
        if (optionalBook.isPresent()) {
            throw new InvalidBookException("Book by ISBN already exists", registerBook.isbn().getISBNFormatted());
        }

        final Book book = Book.registerBy(registerBook);
        bookRepository.save(book);

        log.info("New book registered successfully with the ISBN: {}", registerBook.isbn());

        return book;
    }

    @Override
    public Book modifyBook(ModifyBook modifyBook) {

        if (modifyBook == null) throw new IllegalArgumentException("ModifyBook cannot be null");

        final Book book = findBookOrThrowException(modifyBook.bookId());
        final Book updatedBook = book.changeBy(modifyBook);

        bookRepository.save(updatedBook);

        log.info("An existing book was updated successfully with the ID: {}", modifyBook.bookId());

        return updatedBook;
    }

    @Override
    public void deleteBook(UUID bookId) {

        if (bookId == null) throw new IllegalArgumentException("bookId cannot be null");

        findBookOrThrowException(bookId);

        bookRepository.deleteById(bookId);

        log.info("An existing book was deleted successfully with the ID: {}", bookId);
    }

    public Book findBookOrThrowException(UUID bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book was not found by Id", bookId.toString()));
    }
}
