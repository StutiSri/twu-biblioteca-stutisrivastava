package com.twu.model.menuoption;

import com.twu.io.output.ConsoleOutput;
import com.twu.model.repository.Repository;

public class QuitMenuOption implements MenuOption {
    private final String QUIT_MESSAGE = "Thank you for using Biblioteca.";
    private final String MENU_OPTION_NAME = "Quit";

    @Override
    public ConsoleOutput action() {
        return new ConsoleOutput(QUIT_MESSAGE);
    }

    @Override
    public String getMenuOptionName() {
        return MENU_OPTION_NAME;
    }
}
