package com.store.litflix.service;

import com.store.litflix.model.Book;
import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}
