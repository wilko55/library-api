package com.bookshelf.models;


public class Shelf {
    private String[] booksAvailable;
    private String[] booksUnavailable;

    public String[] getBooksUnavailable() {
        return booksUnavailable;
    }

    public void setBooksUnavailable(String[] booksUnavailable) {
        this.booksUnavailable = booksUnavailable;
    }

    public String[] getBooksAvailable() {
        return booksAvailable;
    }

    public void setBooksAvailable(String[] booksAvailable) {
        this.booksAvailable = booksAvailable;
    }

    public void checkout(){

    };

    public void request(){
    };


}
