package com.twu.model.menuoption;

import com.twu.model.artifacts.Artifact;
import com.twu.io.output.ConsoleOutput;
import com.twu.model.artifacts.Book;
import com.twu.model.repository.LibraryRepository;
import com.twu.model.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class ListBooksMenuOption implements MenuOption {

    private final LibraryRepository repository;
    private final String MENU_OPTION_NAME = "List Books";

    public ListBooksMenuOption(LibraryRepository libraryRepository) {

        this.repository = libraryRepository;
    }

    @Override
    public ConsoleOutput action() {
        List<Book> allBooks = repository.getAvailableBooks();
        List<String> bookListing = new ArrayList<>();
        bookListing.add("\nAvailable Books :-\n");
        addColumnNames(bookListing);
        for(Artifact book : allBooks)
            bookListing.add(book.toString());
        bookListing.add("--------------------------------------------------\n");
        return new ConsoleOutput(bookListing);
    }

    @Override
    public String getMenuOptionName() {
        return MENU_OPTION_NAME;
    }

    private void addColumnNames(List<String> bookListing) {
        String column = String.format("%-30s%-29s%-14s", "Title","Author",
                "Year Published\n");
        bookListing.add(column);
    }
}
