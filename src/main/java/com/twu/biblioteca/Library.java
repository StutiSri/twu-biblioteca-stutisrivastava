package com.twu.biblioteca;

import com.twu.io.input.Input;
import com.twu.io.inputreader.InputReader;
import com.twu.io.output.ConsoleOutput;
import com.twu.io.output.Output;
import com.twu.io.outputwriter.OutputWriter;
import com.twu.model.menuoption.MenuOption;

import java.util.ArrayList;

public class Library {

    private static final String WELCOME_MESSAGE = "Hello User! Welcome to " +
            "Biblioteca! :)\n";
    private Menu menu;

    public Library() {
        this.menu = new Menu();
    }

    public void openLibrary(OutputWriter outputWriter, InputReader inputReader) {
        Output welcomeMessage = getWelcomeMessage();
        outputWriter.write(welcomeMessage);

        Output menuOptions = menu.getMenuOptions();
        outputWriter.write(menuOptions);

        Input menuOptionInput = inputReader.read();
        MenuOption menuOption = getMenuOptionForOption(menuOptionInput.getInput());
        Output menuOptionAcknowledgement = new ConsoleOutput(menuOption.toString());
        outputWriter.write(menuOptionAcknowledgement);
    }

    public Output getWelcomeMessage() {
        ArrayList<String> messages = new ArrayList<>();
        messages.add(WELCOME_MESSAGE);
        return new ConsoleOutput(messages);
    }

    public MenuOption getMenuOptionForOption(String option) {
        return menu.getMenuForOption(option);
    }
}
