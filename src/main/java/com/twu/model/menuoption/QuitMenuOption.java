package com.twu.model.menuoption;

import com.twu.io.output.ConsoleOutput;
import com.twu.model.repository.Repository;

public class QuitMenuOption implements MenuOption {
    private final String QUIT_MESSAGE = "Thank you for using Biblioteca.";

    @Override
    public ConsoleOutput action() {
        return new ConsoleOutput(QUIT_MESSAGE);
    }
}
