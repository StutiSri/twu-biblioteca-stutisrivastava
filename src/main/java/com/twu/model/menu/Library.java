package com.twu.model.menu;

import com.twu.output.ConsoleOutput;
import com.twu.output.Output;

public class Library {

    private static final String WELCOME_MESSAGE = "Hello User! Welcome to " +
            "Biblioteca! :)\n";

    public Output getWelcomeMessage() {
        return new ConsoleOutput(WELCOME_MESSAGE);
    }
}
