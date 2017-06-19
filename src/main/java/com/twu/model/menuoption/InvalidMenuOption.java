package com.twu.model.menuoption;

import com.twu.io.output.ConsoleOutput;

public class InvalidMenuOption implements MenuOption {
    private final String ERROR_MESSAGE = "Select a valid option!\n";

    @Override
    public ConsoleOutput action() {
        return new ConsoleOutput(ERROR_MESSAGE);
    }

    @Override
    public String getMenuOptionName() {
        return null;
    }
}
