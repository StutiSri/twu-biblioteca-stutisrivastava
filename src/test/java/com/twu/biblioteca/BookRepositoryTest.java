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
        String bookToBeCheckedOut = "Atlas Shrugged";
        TestBookRepository testBookRepository = new TestBookRepository();
        testBookRepository.checkoutBook(bookToBeCheckedOut);
        List<Book> expectedBooks = testBookRepository.getAvailableBooks();
        BookRepository bookRepository = new BookRepository();
        bookRepository.checkoutBook(bookToBeCheckedOut);

        List<Book> books = bookRepository.getAvailableBooks();

        assertEquals(expectedBooks, books);
    }

    @Test
    public void shouldCheckoutAnAvailableBook(){
        BookRepository bookRepository = new BookRepository();
        String bookToBeCheckedOut = "life of pi";
        assertTrue(bookRepository.checkoutBook(bookToBeCheckedOut));
    }

    @Test
    public void shouldNotCheckoutAnUnavailableBook(){
        BookRepository bookRepository = new BookRepository();
        String bookToBeCheckedOut = "harry potter";
        assertFalse(bookRepository.checkoutBook(bookToBeCheckedOut));
    }

    @Test
    public void shouldReturnACheckedOutBook(){
        BookRepository bookRepository = new BookRepository();
        String bookTitle = "game of thrones";
        bookRepository.checkoutBook(bookTitle);
        assertTrue(bookRepository.returnBook(bookTitle));
    }

    @Test
    public void shouldNotReturnABookThatIsNotCheckedOut(){
        BookRepository bookRepository = new BookRepository();
        String bookTitle = "game of thrones";
        assertFalse(bookRepository.returnBook(bookTitle));
    }
}
