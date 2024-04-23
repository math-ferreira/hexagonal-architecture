package com.hexagonal.adapter.persistence.jpa;

import com.hexagonal.adapter.persistence.mapper.BookMapper;
import com.hexagonal.application.repositories.BookRepository;
import com.hexagonal.domain.model.Book;
import com.hexagonal.domain.valueobjects.ISBN;
import com.hexagonal.infraestructure.repositories.BookInfraJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class BookSpringDataJpaRepository implements BookRepository {

    private final BookInfraJpaRepository bookInfraJpaRepository;

    public BookSpringDataJpaRepository(BookInfraJpaRepository bookInfraJpaRepository) {
        this.bookInfraJpaRepository = bookInfraJpaRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookInfraJpaRepository.findAll()
                .stream().map(BookMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Book> findById(UUID bookId) {
        return bookInfraJpaRepository.findById(bookId)
                .map(BookMapper::toDomain);
    }

    @Override
    public Optional<Book> findByIsbn(ISBN isbn) {
        return bookInfraJpaRepository.findByIsbn(isbn.value())
                .map(BookMapper::toDomain);
    }

    @Override
    public void save(Book book) {
        bookInfraJpaRepository.save(
                BookMapper.toEntity(book)
        );
    }

    @Override
    public void deleteById(UUID bookId) {
        bookInfraJpaRepository.deleteById(bookId);
    }
}
