package com.store.litflix.service.impl;

import com.store.litflix.dto.BookDto;
import com.store.litflix.dto.CreateBookRequestDto;
import com.store.litflix.dto.UpdateBookRequestDto;
import com.store.litflix.exception.EntityNotFoundException;
import com.store.litflix.mapper.BookMapper;
import com.store.litflix.model.Book;
import com.store.litflix.repository.BookRepository;
import com.store.litflix.service.BookService;
import java.util.List;
import java.util.Optional;
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
        return bookMapper.toDto(savedBook);
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public BookDto updateBook(Long id, UpdateBookRequestDto requestDto) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = bookRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Book not "
                                                                   + "found with id " + id));
            bookMapper.updateModelFromDto(requestDto, book);
            bookRepository.save(book);
            return bookMapper.toDto(book);
        } else {
            throw new EntityNotFoundException("Book not found with id " + id);
        }
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
