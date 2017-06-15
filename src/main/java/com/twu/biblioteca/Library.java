package com.twu.biblioteca;

import com.twu.model.menuoption.MenuOption;
import com.twu.output.ConsoleOutput;
import com.twu.output.Output;
import com.twu.outputwriter.OutputWriter;

import java.util.ArrayList;

public class Library {

    private static final String WELCOME_MESSAGE = "Hello User! Welcome to " +
            "Biblioteca! :)\n";


    public void openLibrary(OutputWriter outputWriter) {
        Output welcomeMessage = getWelcomeMessage();
        outputWriter.write(welcomeMessage);

        Output menuOptions = new Menu().getMenuOptions();
        outputWriter.write(menuOptions);
    }

    public Output getWelcomeMessage() {
        ArrayList<String> messages = new ArrayList<>();
        messages.add(WELCOME_MESSAGE);
        return new ConsoleOutput(messages);
    }

    public MenuOption getMenuOptionForOption(String option) {
        return null;
    }
}
