package com.store.litflix.service.impl;

import com.store.litflix.dto.BookDto;
import com.store.litflix.dto.CreateBookRequestDto;
import com.store.litflix.mapper.BookMapper;
import com.store.litflix.model.Book;
import com.store.litflix.repository.BookRepository;
import com.store.litflix.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto requestDto) {
        Book book = bookMapper.toModel(requestDto);
        Book savedBook = bookRepository.save(book);
        BookDto bookDto = bookMapper.toDto(savedBook);
        return bookDto;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id);
    }
}
