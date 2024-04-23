package com.hexagonal.application.repositories;

import com.hexagonal.domain.model.Book;
import com.hexagonal.domain.valueobjects.ISBN;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository {

    List<Book> findAll();

    Optional<Book> findById(UUID bookId);

    Optional<Book> findByIsbn(ISBN isbn);

    void save(Book book);

    void deleteById(UUID bookId);
}
