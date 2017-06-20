package com.twu.model.repository;

import com.twu.model.artifacts.*;
import com.twu.model.sorter.BookSorter;
import com.twu.model.sorter.MovieSorter;
import com.twu.model.user.Customer;

import java.util.*;

import static com.twu.model.artifacts.ItemType.BOOK;
import static com.twu.model.artifacts.ItemType.MOVIE;


public class LibraryRepository {
    private List<LibraryItem> availableLibraryItems;
    private Map<LibraryItem, Customer> checkedOutLibraryItems;
    private List<Movie> availableMovies;

    public LibraryRepository(){
        availableLibraryItems = new ArrayList<>();
        checkedOutLibraryItems = new HashMap<>();
        addBooks();
        addMovies();
    }

    private void addMovies() {
        List<Movie> movies = getMovies();
        for (Movie movie : movies)
            availableLibraryItems.add(new LibraryItem(movie, ItemType.MOVIE));
    }

    private void addBooks() {
        List<Book> books = getBooks();
        for(Book book : books)
            availableLibraryItems.add(new LibraryItem(book, BOOK));
    }

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Life of Pi", "Yann Martel", "2001"));
        books.add(new Book("Fellowship of the Ring", "J. R. R. Tolkein","1991"));
        books.add(new Book("Atlas Shrugged", "Ayn Rand", "1939"));
        books.add(new Book("The Immortals of Meluha", "Amish Tripathi", "2010"));
        books.add(new Book("Game of Thrones", "George R. R. Martin", "2001"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "1960"));
        return books;
    }

    public List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("The Sixth Sense", "1999", "M. Night Shyamalan", "8.1"));
        movies.add(new Movie("Love Actually", "2003", "Richard Curtis", null));
        movies.add(new Movie("When Harry Met Sally", "1989", "Rob Reiner", "7.6"));
        movies.add(new Movie("Pretty Woman", "1990", "Garry Marshall", "6.9"));
        movies.add(new Movie("Sleepless in Seattle", "1993", "Nora Ephron", "6.8"));
        movies.add(new Movie("Notting Hill", "1999", "Roger Michell", "7.0"));
        return movies;
    }

    public Book checkoutBook(String bookToBeCheckedOut, Customer customer) {
        return (Book) checkoutLibraryItem(bookToBeCheckedOut, BOOK, customer);
    }

    public Movie checkoutMovie(String movieToBeCheckedOut, Customer customer) {
        return (Movie)checkoutLibraryItem(movieToBeCheckedOut, MOVIE, customer);
    }

    private Artifact checkoutLibraryItem(String itemToBeCheckedOut, ItemType type, Customer customer) {
        LibraryItem checkedOutLibraryItem = null;
        for(LibraryItem libraryItem : availableLibraryItems){
            if(libraryItem.getType() == type
                    && libraryItem.getTitle().equalsIgnoreCase(itemToBeCheckedOut)) {
                checkedOutLibraryItems.put(libraryItem, customer);
                checkedOutLibraryItem = libraryItem;
                break;
            }
        }
        if(checkedOutLibraryItem == null)
            return null;
        availableLibraryItems.remove(checkedOutLibraryItem);
        return checkedOutLibraryItem.getArtifact();
    }

    public List<Book> getAvailableBooks() {
        List<Book> books = new ArrayList<>();
        for(LibraryItem libraryItem : availableLibraryItems){
            if(libraryItem.getType() == BOOK) {
                books.add((Book) libraryItem.getArtifact());
            }
        }
        Collections.sort(books, new BookSorter());
        return books;
    }

    public boolean returnBook(String bookTitle) {
        return returnLibraryItem(bookTitle, BOOK);
    }

    private boolean returnLibraryItem(String itemToBeReturned, ItemType type) {
        LibraryItem returnedItem = null;
        for(Map.Entry checkedoutEntry : checkedOutLibraryItems.entrySet()){
            LibraryItem item = (LibraryItem) checkedoutEntry.getKey();
            if(item.getType() == type && item.getTitle().equalsIgnoreCase(itemToBeReturned)){
                returnedItem = item;
                break;
            }
        }
        if(returnedItem == null)
            return false;
        availableLibraryItems.add(returnedItem);
        checkedOutLibraryItems.remove(returnedItem);
        return true;
    }

    public List<Movie> getAvailableMovies() {
        List<Movie> movies = new ArrayList<>();
        for(LibraryItem libraryItem : availableLibraryItems){
            if(libraryItem.getType() == MOVIE) {
                movies.add((Movie) libraryItem.getArtifact());
            }
        }
        Collections.sort(movies, new MovieSorter());
        return movies;
    }

    public boolean returnMovie(String movieTitle) {
        return returnLibraryItem(movieTitle, MOVIE);
    }

    public List<String> getCheckedOutBookListing() {
        if(checkedOutLibraryItems.size() == 0)
            return null;
        List<String> checkedOutBooks = getCheckedOutItems(BOOK);
        if(checkedOutBooks.size() == 1)
            return null;
        return checkedOutBooks;
    }

    private List<String> getCheckedOutItems(ItemType type) {
        List<String> listing = new ArrayList<>();
        listing.add(String.format("%-20s %-20s %-20s","Title", "User Name", "Library Number"));
        for(Map.Entry checkedOutItemEntry : checkedOutLibraryItems.entrySet()){
            LibraryItem libraryItem = (LibraryItem)checkedOutItemEntry.getKey();
            if(libraryItem.getType() != type)
                continue;
            Artifact artifact = libraryItem.getArtifact();
            Customer customer = (Customer)checkedOutItemEntry.getValue();
            getCheckedOutItemDetails(listing, artifact, customer);
        }
        return listing;
    }

    public void getCheckedOutItemDetails(List<String> details, Artifact artifact, Customer customer) {
        details.add(String.format("%-20s %-20s %-20s",artifact.getTitle(), customer.getName(), customer.getLibraryNumber()));
    }

    public List<String> getCheckedOutMovieListing() {
        if(checkedOutLibraryItems.size() == 0)
            return null;
        List<String> checkedOutMovies = getCheckedOutItems(MOVIE);
        if(checkedOutMovies.size() == 1)
            return null;
        return checkedOutMovies;
    }
}
