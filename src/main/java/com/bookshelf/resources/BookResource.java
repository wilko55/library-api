package com.bookshelf.resources;

        import com.bookshelf.db.BookDAO;
        import com.bookshelf.models.Book;
        import com.google.common.base.Optional;
        import io.dropwizard.hibernate.UnitOfWork;
        import io.dropwizard.jersey.params.LongParam;
        import javax.ws.rs.NotFoundException;

        import javax.ws.rs.core.MediaType;


        import javax.ws.rs.GET;
        import javax.ws.rs.Path;
        import javax.ws.rs.PathParam;
        import javax.ws.rs.Produces;

@Path("/books/{bookId}")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    private final BookDAO booksDAO;

    public BookResource(BookDAO booksDAO) {
        this.booksDAO = booksDAO;
    }

    @GET
    @UnitOfWork
    public Book getBook(@PathParam("bookId") LongParam bookId) {
        return findSafely(bookId.get());
    }

    private Book findSafely(long bookId) {
        final Optional<Book> book = booksDAO.findById(bookId);
        if (!book.isPresent()) {
            throw new NotFoundException("No such book.");
        }
        return book.get();
    }
}