package com.store.litflix.service;

import com.store.litflix.dto.BookDto;
import com.store.litflix.dto.CreateBookRequestDto;
import com.store.litflix.dto.UpdateBookRequestDto;
import com.store.litflix.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {
    BookDto save(CreateBookRequestDto requestDto);

    List<Book> findAll();

    Optional<Book> findById(Long id);

    BookDto updateBook(Long id, UpdateBookRequestDto requestDto);

    void deleteById(Long id);
}
