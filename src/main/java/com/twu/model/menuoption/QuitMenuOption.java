package com.twu.model.menuoption;

import com.twu.biblioteca.BookRepository;
import com.twu.io.output.ConsoleOutput;

public class QuitMenuOption implements MenuOption {
    private final String MENU_OPTION = "Quit";
    private final String QUIT_MESSAGE = "Thank you for using Biblioteca.";

    @Override
    public String toString() {
        return MENU_OPTION;
    }

    @Override
    public ConsoleOutput action(BookRepository bookRepository) {
        return new ConsoleOutput(QUIT_MESSAGE);
    }
}
