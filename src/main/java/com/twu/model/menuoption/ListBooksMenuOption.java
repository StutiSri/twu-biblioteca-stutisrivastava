package com.twu.model.menuoption;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.BookRepository;
import com.twu.io.output.ConsoleOutput;

import java.util.ArrayList;
import java.util.List;

public class ListBooksMenuOption implements MenuOption {

    private final String MENU_OPTION_MESSAGE = "List Books";

    @Override
    public String toString() {
        return MENU_OPTION_MESSAGE;
    }

    @Override
    public ConsoleOutput action(BookRepository bookRepository) {
        List<Book> allBooks = bookRepository.getAllBooks();
        List<String> bookListing = new ArrayList<>();
        bookListing.add("\nAvailable Books :-\n");
        addColumnNames(bookListing);
        for(Book book : allBooks)
            addFormattedBookToBookListing(bookListing, book);
        bookListing.add("--------------------------------------------------\n");
        return new ConsoleOutput(bookListing);
    }

    private void addFormattedBookToBookListing(List<String> bookListing, Book book) {
        String bookRepresentation = String.format("%-30s%-30s%-14s",book.getTitle(),
                   book.getAuthor(), book.getYearPublished());
        bookListing.add(bookRepresentation);
    }

    private void addColumnNames(List<String> bookListing) {
        String column = String.format("%-30s%-29s%-14s", "Title","Author",
                "Year Published\n");
        bookListing.add(column);
    }
}
