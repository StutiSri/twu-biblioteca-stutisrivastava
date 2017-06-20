package com.twu.model.menuoption;

import com.twu.io.output.ConsoleOutput;
import com.twu.model.repository.LibraryRepository;

import java.util.List;

public class ListCheckedOutMoviesMenuOption implements MenuOption {

    private final String NO_MOVIES_CHECKED_OUT = "\nThere are no checked out movies.";
    private final String MENU_OPTION_NAME = "List checked out movies";
    private final LibraryRepository repository;

    public ListCheckedOutMoviesMenuOption(LibraryRepository repository) {
        this.repository = repository;
    }

    @Override
    public ConsoleOutput action() {
        List<String> movieListing = repository.getCheckedOutMovieListing();
        if(movieListing == null)
            return new ConsoleOutput(NO_MOVIES_CHECKED_OUT);
        return new ConsoleOutput(movieListing);
    }

    @Override
    public String getMenuOptionName() {
        return MENU_OPTION_NAME;
    }
}
