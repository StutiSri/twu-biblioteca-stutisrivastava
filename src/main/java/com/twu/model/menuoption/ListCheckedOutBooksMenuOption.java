package com.twu.model.menuoption;

import com.twu.io.output.ConsoleOutput;
import com.twu.model.repository.LibraryRepository;

public class ListCheckedOutBooksMenuOption implements MenuOption {

    private final String MENU_OPTION_NAME = "List checked out books";

    public ListCheckedOutBooksMenuOption(LibraryRepository repository) {
    }

    @Override
    public ConsoleOutput action() {
        return null;
    }

    @Override
    public String getMenuOptionName() {
        return MENU_OPTION_NAME;
    }
}
