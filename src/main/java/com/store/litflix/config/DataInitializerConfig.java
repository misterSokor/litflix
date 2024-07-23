package com.store.litflix.config;

import com.store.litflix.model.Book;
import com.store.litflix.service.BookService;
import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//this is to test the application work
@Configuration
public class DataInitializerConfig {

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
