package com.twu.model.menuoption;

import com.twu.biblioteca.BookRepository;
import com.twu.io.output.ConsoleOutput;

public class ReturnBookMenuOption implements MenuOption {
    @Override
    public ConsoleOutput action(BookRepository bookRepository) {
        return null;
    }
}
