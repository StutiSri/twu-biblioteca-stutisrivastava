package com.twu.biblioteca;

import com.twu.mockmodels.TestBookRepository;
import com.twu.model.artifacts.Artifact;
import com.twu.model.artifacts.Book;
import com.twu.model.repository.BookRepository;
import com.twu.model.repository.Repository;
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
        testBookRepository.checkoutArtifact(bookToBeCheckedOut);
        List<Artifact> expectedBooks = testBookRepository.getAvailableArtifacts();
        Repository repository = new BookRepository();
        repository.checkoutArtifact(bookToBeCheckedOut);

        List<Artifact> books = repository.getAvailableArtifacts();

        assertEquals(expectedBooks, books);
    }

    @Test
    public void shouldCheckoutAnAvailableBook(){
        Repository repository = new BookRepository();
        String bookToBeCheckedOut = "life of pi";
        assertTrue(repository.checkoutArtifact(bookToBeCheckedOut));
    }

    @Test
    public void shouldNotCheckoutAnUnavailableBook(){
        Repository repository = new BookRepository();
        String bookToBeCheckedOut = "harry potter";
        assertFalse(repository.checkoutArtifact(bookToBeCheckedOut));
    }

    @Test
    public void shouldReturnACheckedOutBook(){
        Repository repository = new BookRepository();
        String bookTitle = "game of thrones";
        repository.checkoutArtifact(bookTitle);
        assertTrue(repository.returnArtifact(bookTitle));
    }

    @Test
    public void shouldNotReturnABookThatIsNotCheckedOut(){
        Repository repository = new BookRepository();
        String bookTitle = "game of thrones";
        assertFalse(repository.returnArtifact(bookTitle));
    }
}
