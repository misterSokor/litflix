package com.store.litflix.repository;

import com.store.litflix.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
//    Book save(Book book);
//
//    List<Book> findAll();
//
//    Book findById(Long id);
}
