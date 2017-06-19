package com.twu.model.menuoption;

import com.twu.io.output.ConsoleOutput;
import com.twu.model.repository.LibraryRepository;

public class ListCheckedOutBooksMenuOption implements MenuOption {
    public ListCheckedOutBooksMenuOption(LibraryRepository repository) {
    }

    @Override
    public ConsoleOutput action() {
        return null;
    }

    @Override
    public String getMenuOptionName() {
        return null;
    }
}
