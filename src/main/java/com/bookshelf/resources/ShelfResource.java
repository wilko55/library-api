package com.bookshelf.resources;


import com.bookshelf.db.BookDAO;
import com.bookshelf.models.Book;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bookshelf")
@Produces(MediaType.APPLICATION_JSON)
public class ShelfResource {

    private final BookDAO booksDAO;

    public ShelfResource(BookDAO booksDAO) {
        this.booksDAO = booksDAO;
    }

    @POST
    @UnitOfWork
    public Book createBook(Book book) {
        return booksDAO.create(book);
    }

    @GET
    @UnitOfWork
    public List<Book> listBooks() {
        return booksDAO.findAll();
    }

}