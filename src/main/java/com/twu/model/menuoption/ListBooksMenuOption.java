package com.twu.model.menuoption;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.BookRepository;
import com.twu.io.output.ConsoleOutput;

import java.util.ArrayList;
import java.util.List;

public class ListBooksMenuOption implements MenuOption {

    @Override
    public ConsoleOutput action(BookRepository bookRepository) {
        List<Book> allBooks = bookRepository.getAvailableBooks();
        List<String> bookListing = new ArrayList<>();
        bookListing.add("\nAvailable Books :-\n");
        addColumnNames(bookListing);
        for(Book book : allBooks)
            bookListing.add(book.toString());
        bookListing.add("--------------------------------------------------\n");
        return new ConsoleOutput(bookListing);
    }

    private void addColumnNames(List<String> bookListing) {
        String column = String.format("%-30s%-29s%-14s", "Title","Author",
                "Year Published\n");
        bookListing.add(column);
    }
}
