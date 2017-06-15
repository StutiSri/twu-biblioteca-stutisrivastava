package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<Book> books;

    public BookRepository(){
        books = new ArrayList<>();
        books.add(new Book("Life of Pi"));
        books.add(new Book("Fellowship of the Ring"));
    }

    public List<Book> getAllBooks() {
        return books;
    }
}
