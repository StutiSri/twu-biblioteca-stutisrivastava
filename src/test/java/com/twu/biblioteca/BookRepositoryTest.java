package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookRepositoryTest {

    @Test
    public void shouldReturnListOfBooks() {
        List<Book> expectedBooks = getExpectedBooks();
        List<Book> books = new BookRepository().getAllBooks();
        assertEquals(expectedBooks, books);
    }

    public List<Book> getExpectedBooks() {
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Book("Life of Pi", "Yann Martel", "2001"));
        expectedBooks.add(new Book("Fellowship of the Ring",
                "J. R. R. Tolkein","1991"));
        expectedBooks.add(new Book("Atlas Shrugged", "Ayn Rand", "1939"));
        expectedBooks.add(new Book("The Immortals of Meluha",
                "Amish Tripathi", "2010"));
        expectedBooks.add(new Book("Game of Thrones", "George R. R. Martin",
                "2001"));
        expectedBooks.add(new Book("To Kill a Mockingbird", "Harper Lee",
                "1960"));
        return expectedBooks;
    }

}
