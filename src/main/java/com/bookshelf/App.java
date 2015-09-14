package com.bookshelf;

import com.bookshelf.db.BookDAO;
import com.bookshelf.models.Book;
import com.bookshelf.models.Shelf;
import com.bookshelf.resources.BookResource;
import io.dropwizard.Application;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.db.DataSourceFactory;


public class App extends Application<BookshelfConfig> {
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    private final HibernateBundle<BookshelfConfig> hibernate = new HibernateBundle<BookshelfConfig>(Book.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(BookshelfConfig configuration) {
            return configuration.getDatabase();        }
    };

    @Override
    public void initialize(Bootstrap<BookshelfConfig> bootstrap) {
        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(BookshelfConfig config, Environment environment) {
        final BookDAO dao = new BookDAO(hibernate.getSessionFactory());
        environment.jersey().register(new BookResource(dao));
    }

}