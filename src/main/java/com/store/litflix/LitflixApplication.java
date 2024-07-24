package com.store.litflix;

import com.store.litflix.model.Book;
import com.store.litflix.service.BookService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LitflixApplication {
    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(LitflixApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(BookService bookService) {
        return args -> {
            Book book = new Book();
            book.setTitle("The Lord of the Rings");
            book.setAuthor("J.R.R. Tolkien");
            book.setPrice(BigDecimal.valueOf(100.00));
            book.setDescription("The Lord of the Rings is an epic high-fantasy novel");
            book.setIsbn("123456789");
            bookService.save(book);
            bookService.findAll().forEach(System.out::println);
        };
    }
}
