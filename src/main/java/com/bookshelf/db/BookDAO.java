package com.bookshelf.db;

import com.bookshelf.models.Book;
import com.google.common.base.Optional;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;


public class BookDAO extends AbstractDAO<Book> {
    public BookDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<Book> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public Book create(Book book) {
        return persist(book);
    }

    public List<Book> findAll() {
        return list(namedQuery("com.bookshelf.models.Book.findAll"));
    }
}
