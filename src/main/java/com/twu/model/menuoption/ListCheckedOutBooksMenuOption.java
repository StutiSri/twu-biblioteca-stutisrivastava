package com.twu.model.menuoption;

import com.twu.io.output.ConsoleOutput;
import com.twu.model.repository.LibraryRepository;

import java.util.List;

public class ListCheckedOutBooksMenuOption implements MenuOption {

    private final String NO_BOOKS_CHECKED_OUT = "\nThere are no checked out books.";
    private final String MENU_OPTION_NAME = "List checked out books";
    private final LibraryRepository repository;

    public ListCheckedOutBooksMenuOption(LibraryRepository repository) {
        this.repository = repository;
    }

    @Override
    public ConsoleOutput action() {
        List<String> bookListing = repository.getCheckedOutBookListing();
        if(bookListing == null)
            return new ConsoleOutput(NO_BOOKS_CHECKED_OUT);
        return new ConsoleOutput(bookListing);
    }

    @Override
    public String getMenuOptionName() {
        return MENU_OPTION_NAME;
    }


}
