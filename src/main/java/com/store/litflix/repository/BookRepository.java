package com.store.litflix.repository;

import com.store.litflix.model.Book;
import java.util.List;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();
}
