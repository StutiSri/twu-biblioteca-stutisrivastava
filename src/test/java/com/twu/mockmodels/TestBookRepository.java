package com.twu.mockmodels;

import com.twu.biblioteca.Book;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestBookRepository {

    private final List<Book> expectedBooks;

    public TestBookRepository(){
        expectedBooks = new ArrayList<>();
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
    }

    public List<Book> getExpectedBooks() {
        return expectedBooks;
    }

    public List<String> getBookListing(){
        List<String> bookListing = new ArrayList<>();
        bookListing.add("\nAvailable Books :-\n");
        addColumnNames(bookListing, "Title", "Author", " Year " +
                "Published");
        for(Book book : expectedBooks)
            addBookInColumnRepresentation(bookListing, book);
        bookListing.add("--------------------------------------------------\n");
        return bookListing;
    }

    private void addColumnNames(List<String> bookListing, String columnTitle,
                                String columnAuthor, String columnYearPublished) {
        String columns = String.format("%-30s%-28s%-14s\n",
                columnTitle, columnAuthor, columnYearPublished);
        bookListing.add(columns);
    }

    private void addBookInColumnRepresentation(List<String> bookListRepresentation, Book book) {
        String bookRepresentation = String.format("%-30s%-30s%-14s",
                book.getTitle(), book.getAuthor(), book.getYearPublished());
        bookListRepresentation.add(bookRepresentation);
    }

}
