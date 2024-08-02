package com.store.litflix.controller;

import com.store.litflix.dto.BookDto;
import com.store.litflix.dto.CreateBookRequestDto;
import com.store.litflix.model.Book;
import com.store.litflix.service.BookService;
import jakarta.servlet.http.HttpServlet;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController extends HttpServlet {
    private final BookService bookService;

    @PostMapping
    BookDto createBook(@RequestBody CreateBookRequestDto requestDto) {
        return bookService.save(requestDto);
    }

    @GetMapping("/{id}")
    Book getBook(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @GetMapping
    List<Book> getAllBooks() {
        return bookService.findAll();
    }
}
