package com.bookshelf;

        import com.fasterxml.jackson.annotation.JsonProperty;
        import io.dropwizard.Configuration;
        import io.dropwizard.db.DataSourceFactory;

        import javax.validation.Valid;
        import javax.validation.constraints.NotNull;

public class BookshelfConfig extends Configuration {
        @Valid
        @NotNull

        @JsonProperty("database")

        private DataSourceFactory database = new DataSourceFactory();

        @JsonProperty
        public DataSourceFactory getDatabase() {
                return database;
        }

        @JsonProperty
        public void setDatabase(DataSourceFactory database) {
                this.database = database;
        }
}