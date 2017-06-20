package com.twu.mockmodels;

import com.twu.model.artifacts.Artifact;
import com.twu.model.artifacts.Book;
import com.twu.model.artifacts.Movie;
import com.twu.model.repository.LibraryRepository;
import com.twu.model.sorter.BookSorter;
import com.twu.model.sorter.MovieSorter;
import com.twu.model.user.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestLibraryRepository extends LibraryRepository {

    private List<Book> books;
    private List<Movie> movies;
    private Book checkedOutBook;
    private boolean isBookCheckedOut;
    private boolean isMovieCheckedOut;
    private Movie checkedOutMovie;
    private Customer movieCheckedOutBy;
    private Customer bookCheckedOutBy;

    public TestLibraryRepository() {
        addBooks();
        addMovies();
    }

    private void addMovies() {
        movies = new ArrayList<>();
        movies.add(new Movie("The Sixth Sense", "1999", "M. Night Shyamalan", "8.1"));
        movies.add(new Movie("Love Actually", "2003", "Richard Curtis", null));

        checkedOutMovie = new Movie("When Harry Met Sally", "1989", "Rob Reiner", "7.6");
        movies.add(checkedOutMovie);

        movies.add(new Movie("Pretty Woman", "1990", "Garry Marshall", "6.9"));
        movies.add(new Movie("Sleepless in Seattle", "1993", "Nora Ephron", "6.8"));
        movies.add(new Movie("Notting Hill", "1999", "Roger Michell", "7.0"));

        Collections.sort(movies, new MovieSorter());
        isMovieCheckedOut = false;
    }

    private void addBooks() {
        books = new ArrayList<>();
        books.add(new Book("Life of Pi", "Yann Martel", "2001"));
        books.add(new Book("Fellowship of the Ring",
                "J. R. R. Tolkein", "1991"));

        checkedOutBook = new Book("Atlas Shrugged", "Ayn Rand", "1939");
        books.add(checkedOutBook);

        books.add(new Book("The Immortals of Meluha",
                "Amish Tripathi", "2010"));
        books.add(new Book("Game of Thrones", "George R. R. Martin",
                "2001"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee",
                "1960"));

        Collections.sort(books, new BookSorter());
        isBookCheckedOut = false;
    }

    @Override
    public Book checkoutBook(String title, Customer customer) {
        if (!(checkedOutBook.getTitle().equalsIgnoreCase(title)))
            return null;
        this.bookCheckedOutBy = customer;
        isBookCheckedOut = true;
        return checkedOutBook;
    }

    @Override
    public boolean returnBook(String title) {
        if (!(checkedOutBook.getTitle().equalsIgnoreCase(title)))
            return false;
        isBookCheckedOut = false;
        return true;
    }

    @Override
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (!(book.equals(checkedOutBook) && isBookCheckedOut))
                availableBooks.add(book);
        }
        return availableBooks;
    }


    public List<String> getBookListing() {
        List<String> bookListing = new ArrayList<>();

        bookListing.add("\nAvailable Books :-\n");
        addColumnNamesForBooks(bookListing);

        for (Book book : books) {
            addBookInColumnRepresentation(bookListing, book);
        }

        bookListing.add("--------------------------------------------------\n");

        return bookListing;
    }

    private void addColumnNamesForBooks(List<String> bookListing) {
        String columns = String.format("%-30s%-28s%-14s\n",
                "Title", "Author", " Year Published");
        bookListing.add(columns);
    }

    private void addBookInColumnRepresentation(List<String> bookListRepresentation, Book book) {
        String bookRepresentation = String.format("%-30s%-30s%-14s",
                book.getTitle(), book.getAuthor(), book.getYearPublished());
        bookListRepresentation.add(bookRepresentation);
    }

    public List<String> getMovieListing() {
        List<String> movieListing = new ArrayList<>();

        movieListing.add("\nAvailable Movies :-\n");
        addColumnNamesForMovies(movieListing);

        for (Movie movie : movies) {
            addMovieInColumnRepresentation(movieListing, movie);
        }

        movieListing.add("--------------------------------------------------\n");

        return movieListing;
    }

    @Override
    public List<Movie> getAvailableMovies() {
        List<Movie> availableMovies = new ArrayList<>();
        for (Movie movie : movies) {
            if (!(movie.equals(checkedOutMovie) && isMovieCheckedOut))
                availableMovies.add(movie);
        }
        return availableMovies;
    }

    @Override
    public Movie checkoutMovie(String title, Customer customer) {
        if (!(checkedOutMovie.getTitle().equalsIgnoreCase(title)))
            return null;
        this.movieCheckedOutBy = customer;
        isMovieCheckedOut = true;
        return checkedOutMovie;
    }

    private void addColumnNamesForMovies(List<String> movieListing) {
        String columns = String.format("%-30s%-17s%-30s%-6s\n",
                "Title", "Year of Release", "Director", "Rating");
        movieListing.add(columns);
    }

    private void addMovieInColumnRepresentation(List<String> movieListRepresentation, Movie movie) {
        String rating = movie.getRating();
        if (movie.getRating() == null)
            rating = "Unrated";
        String movieRepresentation = String.format("%-30s%-17s%-30s%-7s",
                movie.getTitle(), movie.getYearOfRelease(), movie.getDirector(), rating);
        movieListRepresentation.add(movieRepresentation);
    }

    @Override
    public List<String> getCheckedOutBookListing() {
        if (!isBookCheckedOut)
            return null;
        return checkedOutListing(checkedOutBook, bookCheckedOutBy);
    }

    @Override
    public List<String> getCheckedOutMovieListing() {
        if (!isMovieCheckedOut)
            return null;
        return checkedOutListing(checkedOutMovie, movieCheckedOutBy);

    }

    private List<String> checkedOutListing(Artifact artifact, Customer checkedOutBy) {
        List<String> listing = new ArrayList<>();
        if (artifact instanceof Book)
            listing.add(String.format("Checked Out Books are :-\n\n%-20s %-20s %-20s", "Title", "User Name", "Library Number"));
        else
            listing.add(String.format("Checked Out Movies are :-\n\n%-20s %-20s %-20s", "Title", "User Name", "Library Number"));
        listing.add(String.format("%-20s %-20s %-20s", artifact.getTitle(), checkedOutBy.getName(),
                checkedOutBy.getLibraryNumber()));
        return listing;
    }

}
