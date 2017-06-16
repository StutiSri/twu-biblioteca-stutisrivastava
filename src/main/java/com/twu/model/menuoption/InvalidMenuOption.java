package com.twu.model.menuoption;

import com.twu.biblioteca.BookRepository;
import com.twu.io.output.ConsoleOutput;

public class InvalidMenuOption implements MenuOption {
    private final String ERROR_MESSAGE = "Select a valid option!\n";

    @Override
    public ConsoleOutput action(BookRepository bookRepository) {
        return new ConsoleOutput(ERROR_MESSAGE);
    }
}
