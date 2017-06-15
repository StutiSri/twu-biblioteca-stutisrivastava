package com.twu.model.menuoption;

import com.twu.biblioteca.BookRepository;
import com.twu.io.output.ConsoleOutput;

public interface MenuOption {
    ConsoleOutput action(BookRepository bookRepository);
}
