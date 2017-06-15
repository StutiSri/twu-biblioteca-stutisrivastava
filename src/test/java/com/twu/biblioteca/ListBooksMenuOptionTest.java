package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListBooksMenuOptionTest {

    @Test
    public void shouldReturnListOfBooks() {
        List<Book> expectedBooks = getExpectedBooks();
        List<Book> books = new BookRepository().getAllBooks();
        assertEquals(expectedBooks, books);
    }

    public List<Book> getExpectedBooks() {
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Book("Life of Pi"));
        expectedBooks.add(new Book("Fellowship of the Ring"));
        return expectedBooks;
    }
}
