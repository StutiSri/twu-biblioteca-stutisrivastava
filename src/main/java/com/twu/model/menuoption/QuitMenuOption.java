package com.twu.model.menuoption;

import com.twu.biblioteca.BookRepository;
import com.twu.io.output.ConsoleOutput;

public class QuitMenuOption implements MenuOption {
    private static final String MENU_OPTION = "Quit";

    @Override
    public String toString() {
        return MENU_OPTION;
    }

    @Override
    public ConsoleOutput action(BookRepository bookRepository) {
        return new ConsoleOutput(MENU_OPTION);
    }
}
