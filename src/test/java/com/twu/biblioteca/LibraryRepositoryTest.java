package com.twu.biblioteca;

import com.twu.mockmodels.TestLibraryRepository;
import com.twu.mockmodels.TestMovieRepository;
import com.twu.model.artifacts.Book;
import com.twu.model.artifacts.Movie;
import com.twu.model.repository.LibraryRepository;
import com.twu.model.user.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class LibraryRepositoryTest {
    private Customer customer;

    @Before
    public void setUp(){
        customer = new Customer("Stuti", "STU-9176", "stuti@gmail.com", "9176835429", "password");
    }

    @Test
    public void shouldCheckoutAnAvailableBook(){
        LibraryRepository repository = new LibraryRepository();
        String bookToBeCheckedOut = "life of pi";
        Book expectedBook = new Book(bookToBeCheckedOut, "Yann Martel", "2001");

        Book book = repository.checkoutBook(bookToBeCheckedOut, customer);

        assertEquals(expectedBook, book);
    }

    @Test
    public void shouldCheckoutAnAvailableMovie(){
        LibraryRepository repository = new LibraryRepository();
        String movieToBeCheckedOut = "when harry met sally";
        Movie expectedMovie = new Movie(movieToBeCheckedOut,  "1989", "Rob Reiner", "7.6");

        Movie movie = repository.checkoutMovie(movieToBeCheckedOut, customer);

        assertEquals(expectedMovie, movie);
    }

    @Test
    public void shouldReturnListOfAvailableBooks() {
        LibraryRepository repository = new LibraryRepository();
        TestLibraryRepository testLibraryRepository = new TestLibraryRepository();
        List<Book> expectedBooks = testLibraryRepository.getAvailableBooks();

        List<Book> books = repository.getAvailableBooks();

        Assert.assertEquals(expectedBooks, books);
    }

    @Test
    public void shouldReturnListOfAvailableMovies() {
        LibraryRepository repository = new LibraryRepository();
        TestMovieRepository testMovieRepository = new TestMovieRepository();
        List<Movie> expectedMovies = testMovieRepository.getAvailableMovies();

        List<Movie> movies = repository.getAvailableMovies();

        Assert.assertEquals(expectedMovies, movies);
    }

    @Test
    public void shouldRemoveCheckedOutBookFromAvailableBooks() {
        String bookToBeCheckedOut = "atlas shrugged";
        LibraryRepository repository = new LibraryRepository();
        TestLibraryRepository testLibraryRepository = new TestLibraryRepository();
        testLibraryRepository.checkoutBook(bookToBeCheckedOut);
        List<Book> expectedBooks = testLibraryRepository.getAvailableBooks();

        repository.checkoutBook(bookToBeCheckedOut, customer);
        List<Book> books = repository.getAvailableBooks();

        Assert.assertEquals(expectedBooks, books);
    }

    @Test
    public void shouldRemoveCheckedOutMovieFromAvailableMovies() {
        String movieToBeCheckedOut = "atlas shrugged";
        LibraryRepository repository = new LibraryRepository();
        TestMovieRepository testMovieRepository = new TestMovieRepository();
        testMovieRepository.checkoutMovie(movieToBeCheckedOut);
        List<Movie> expectedMovies = testMovieRepository.getAvailableMovies();

        repository.checkoutMovie(movieToBeCheckedOut, customer);
        List<Movie> movies = repository.getAvailableMovies();

        Assert.assertEquals(expectedMovies, movies);
    }

    @Test
    public void shouldNotCheckoutAnUnavailableBook(){
        LibraryRepository repository = new LibraryRepository();
        String bookToBeCheckedOut = "harry potter";

        Book checkedOutBook = repository.checkoutBook(bookToBeCheckedOut, customer);

        assertNull(checkedOutBook);
    }

    @Test
    public void shouldNotCheckoutAnUnavailableMovie(){
        LibraryRepository repository = new LibraryRepository();
        String movieToBeCheckedOut = "harry potter";

        Movie checkedOutMovie = repository.checkoutMovie(movieToBeCheckedOut, customer);

        assertNull(checkedOutMovie);
    }

    @Test
    public void shouldReturnACheckedOutBook(){
        LibraryRepository repository = new LibraryRepository();
        String bookTitle = "game of thrones";
        repository.checkoutBook(bookTitle, customer);

        assertTrue(repository.returnBook(bookTitle));

    }

    @Test
    public void shouldReturnACheckedOutMovie(){
        LibraryRepository repository = new LibraryRepository();
        String movieTitle = "notting hill";
        repository.checkoutMovie(movieTitle, customer);

        assertTrue(repository.returnMovie(movieTitle));

    }

    @Test
    public void shouldNotReturnABookThatIsNotCheckedOut(){
        LibraryRepository repository = new LibraryRepository();
        String bookTitle = "game of thrones";

        assertFalse(repository.returnBook(bookTitle));
    }

    @Test
    public void shouldNotReturnAMovieThatIsNotCheckedOut(){
        LibraryRepository repository = new LibraryRepository();
        String movieTitle = "game of thrones";

        assertFalse(repository.returnMovie(movieTitle));
    }

    @Test
    public void bookShouldBeAddedToAvailableBooksAfterReturn(){
        LibraryRepository repository = new LibraryRepository();
        TestLibraryRepository testLibraryRepository = new TestLibraryRepository();
        String bookTitle = "atlas shrugged";
        repository.checkoutBook(bookTitle, customer);
        List<Book> expectedBooks = testLibraryRepository.getAvailableBooks();

        repository.returnBook(bookTitle);
        List<Book> books = repository.getAvailableBooks();

        Assert.assertEquals(expectedBooks, books);
    }

    @Test
    public void movieShouldBeAddedToAvailableMoviesAfterReturn(){
        LibraryRepository repository = new LibraryRepository();
        TestMovieRepository testMovieRepository = new TestMovieRepository();
        String movieTitle = "notting hill";
        repository.checkoutMovie(movieTitle, customer);
        List<Movie> expectedMovies = testMovieRepository.getAvailableMovies();

        repository.returnMovie(movieTitle);
        List<Movie> movies = repository.getAvailableMovies();

        Assert.assertEquals(expectedMovies, movies);
    }

}
