package com.twu.mockmodels;

import com.twu.model.artifacts.Artifact;
import com.twu.model.artifacts.Book;
import com.twu.model.artifacts.BookSorter;
import com.twu.model.repository.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestBookRepository implements Repository{

    private final List<Book> books;
    private Book checkedOutBook;
    private boolean isBookCheckedOut;

    public TestBookRepository(){
        books = new ArrayList<>();
        books.add(new Book("Life of Pi", "Yann Martel", "2001"));
        books.add(new Book("Fellowship of the Ring",
                "J. R. R. Tolkein","1991"));

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
    public boolean checkoutArtifact(String title) {
        if(!checkedOutBook.getTitle().equalsIgnoreCase(title))
            return false;
        isBookCheckedOut = true;
        return true;
    }

    @Override
    public boolean returnArtifact(String title) {
        if(!checkedOutBook.getTitle().equalsIgnoreCase(title))
            return false;
        isBookCheckedOut = false;
        return true;
    }

    @Override
    public List<Artifact> getAvailableArtifacts() {
        List<Artifact> availableBooks = new ArrayList<>();
        for(Book book : books) {
            if(!(book.equals(checkedOutBook) && isBookCheckedOut))
                availableBooks.add(book);
        }
        return availableBooks;
    }

    public List<String> getBookListing(){
        List<String> bookListing = new ArrayList<>();

        bookListing.add("\nAvailable Books :-\n");
        addColumnNames(bookListing);

        for(Book book : books) {
                addBookInColumnRepresentation(bookListing, book);
        }

        bookListing.add("--------------------------------------------------\n");

        return bookListing;
    }

    private void addColumnNames(List<String> bookListing) {
        String columns = String.format("%-30s%-28s%-14s\n",
                "Title", "Author", " Year Published");
        bookListing.add(columns);
    }

    private void addBookInColumnRepresentation(List<String> bookListRepresentation, Book book) {
        String bookRepresentation = String.format("%-30s%-30s%-14s",
                book.getTitle(), book.getAuthor(), book.getYearPublished());
        bookListRepresentation.add(bookRepresentation);
    }

}
