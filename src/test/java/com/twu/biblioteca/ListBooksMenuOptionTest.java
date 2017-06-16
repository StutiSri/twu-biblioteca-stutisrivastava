package com.twu.biblioteca;

import com.twu.io.output.ConsoleOutput;
import com.twu.model.menuoption.ListBooksMenuOption;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListBooksMenuOptionTest {

    @Test
    public void detailsInBookListingShouldBeFormattedAsColumns() {
        ConsoleOutput expectedBookListingOutput = new ConsoleOutput
                (getBookListing());

        ConsoleOutput bookListOutput = new ListBooksMenuOption().action(new BookRepository());

        assertEquals(expectedBookListingOutput, bookListOutput);
    }

    public List<String> getBookListing() {
        List<String> bookListing = new ArrayList<>();
        bookListing.add("\nAvailable Books :-\n");
        addColumnNames(bookListing, "Title", "Author", " Year " +
                "Published");
        addBookInColumnRepresentation(bookListing,
                new Book("Life of Pi", "Yann Martel", "2001"));
        addBookInColumnRepresentation(bookListing,
                new Book("Fellowship of the Ring", "J. R. R. Tolkein", "1991"));
        addBookInColumnRepresentation(bookListing,
                 new Book("Atlas Shrugged", "Ayn Rand", "1939"));
        addBookInColumnRepresentation(bookListing,
                new Book("The Immortals of Meluha", "Amish Tripathi", "2010"));
        addBookInColumnRepresentation(bookListing,
                new Book("Game of Thrones", "George R. R. Martin", "2001"));
        addBookInColumnRepresentation(bookListing,
                new Book("To Kill a Mockingbird", "Harper Lee", "1960"));
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

