package com.twu.biblioteca;

import com.twu.mockmodels.TestBookRepository;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BookRepositoryTest {

    @Test
    public void shouldReturnListOfAvailableBooks() {
        TestBookRepository testBookRepository = new TestBookRepository();
        testBookRepository.checkoutBook();
        List<Book> expectedBooks = testBookRepository.getBooks();
        BookRepository bookRepository = new BookRepository();
        String bookToBeCheckedOut = "Atlas Shrugged";
        bookRepository.checkoutBook(bookToBeCheckedOut);

        List<Book> books = bookRepository.getAvailableBooks();

        assertEquals(expectedBooks, books);
    }

    @Test
    public void shouldBeAbleToCheckoutAnAvailable(){
        BookRepository bookRepository = new BookRepository();
        String bookToBeCheckedOut = "life of pi";
        assertTrue(bookRepository.checkoutBook(bookToBeCheckedOut));
    }

    @Test
    public void shouldNotCheckoutABookThatIsNotAvailable(){
        BookRepository bookRepository = new BookRepository();
        String bookToBeCheckedOut = "harry potter";
        assertFalse(bookRepository.checkoutBook(bookToBeCheckedOut));
    }

}
