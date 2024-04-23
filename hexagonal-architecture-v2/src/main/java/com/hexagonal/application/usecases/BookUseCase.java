package com.hexagonal.application.usecases;

import com.hexagonal.domain.command.ModifyBook;
import com.hexagonal.domain.command.RegisterBook;
import com.hexagonal.domain.model.Book;

import java.util.List;
import java.util.UUID;

public interface BookUseCase {

    List<Book> getAllBooks();

    Book registerBook(RegisterBook registerBook);

    Book modifyBook(ModifyBook modifyBook);

    void deleteBook(UUID bookId);

}
