package com.twu.model.menuoption;

import com.twu.biblioteca.BookRepository;
import com.twu.io.output.ConsoleOutput;

public class ReturnBookMenuOption implements MenuOption {
    private final String MENU_OPTION_MESSAGE = "Return Book";

    @Override
    public ConsoleOutput action(BookRepository bookRepository) {
        return null;
    }

    @Override
    public String toString() {
        return MENU_OPTION_MESSAGE;
    }
}
