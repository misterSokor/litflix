package com.store.litflix.repository.impl;

import com.store.litflix.exception.DataProcessingException;
import com.store.litflix.model.Book;
import com.store.litflix.repository.BookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {
    private final EntityManagerFactory entityManagerFactory;

    @Override
    public Book save(Book book) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(book);
            transaction.commit();
            return book;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert Book entity", e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<Book> findAll() {
        try (EntityManager entityManager = entityManagerFactory
                .createEntityManager()) {
            return entityManager.createQuery(
                    "from Book", Book.class).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all Book entities", e);
        }
    }

    @Override
    public Book findById(Long id) {
        try (EntityManager entityManager =
                     entityManagerFactory.createEntityManager()) {
            return entityManager.find(Book.class, id);
        } catch (Exception e) {
            throw new DataProcessingException(
                    "Can't find Book entity by id: " + id, e);
        }
    }
}
