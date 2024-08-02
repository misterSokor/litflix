package com.store.litflix.service;

import com.store.litflix.dto.BookDto;
import com.store.litflix.dto.CreateBookRequestDto;
import com.store.litflix.model.Book;
import java.util.List;

public interface BookService {
    BookDto save(CreateBookRequestDto requestDto);

    List<Book> findAll();

    Book findById(Long id);
}
