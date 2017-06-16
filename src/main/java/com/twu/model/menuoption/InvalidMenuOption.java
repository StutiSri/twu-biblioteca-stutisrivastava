package com.twu.model.menuoption;

import com.twu.biblioteca.BookRepository;
import com.twu.io.output.ConsoleOutput;

public class InvalidMenuOption implements MenuOption {
    private final String ERROR_MESSAGE = "Invalid Menu Option Selected\n";

    @Override
    public String toString() {
        return ERROR_MESSAGE;
    }

    @Override
    public ConsoleOutput action(BookRepository bookRepository) {
        return new ConsoleOutput(ERROR_MESSAGE);
    }
}
