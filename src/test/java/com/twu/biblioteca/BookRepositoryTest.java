package com.twu.biblioteca;

import com.twu.mockmodels.TestBookRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookRepositoryTest {

    @Test
    public void shouldReturnListOfBooks() {
        List<Book> expectedBooks = new TestBookRepository().getExpectedBooks();
        List<Book> books = new BookRepository().getAllBooks();
        assertEquals(expectedBooks, books);
    }


}
