package com.twu.biblioteca;

import com.twu.output.ConsoleOutput;
import com.twu.output.Output;
import com.twu.outputwriter.OutputWriter;

public class Library {

    private static final String WELCOME_MESSAGE = "Hello User! Welcome to " +
            "Biblioteca! :)\n";

    public void startLibraryFunctions(OutputWriter outputWriter) {
        Library library = new Library();
        Output welcomeMessage = library.getWelcomeMessage();
        outputWriter.write(welcomeMessage);

//        Output menuOptions = new Menu().getMenuOptions();
//        outputWriter.write(menuOptions);
    }

    public Output getWelcomeMessage() {
        return new ConsoleOutput(WELCOME_MESSAGE);
    }
}
