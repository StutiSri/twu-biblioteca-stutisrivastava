package com.twu.biblioteca;

import com.twu.io.input.ConsoleInput;
import com.twu.io.inputreader.InputReader;
import com.twu.io.output.ConsoleOutput;
import com.twu.io.outputwriter.OutputWriter;
import com.twu.model.menuoption.MenuOption;
import com.twu.model.menuoption.QuitMenuOption;

public class Library {

    private static final String WELCOME_MESSAGE = "Hello User! Welcome to " +
            "Biblioteca! :)\n";
    private Menu menu;

    public Library() {
        this.menu = new Menu();
    }

    public void startLibrary(OutputWriter outputWriter, InputReader inputReader) {
        ConsoleOutput welcomeMessage = new ConsoleOutput(WELCOME_MESSAGE);
        outputWriter.write(welcomeMessage);

        ConsoleOutput menuOptionsOutput = menu.getMenuOptions();
        MenuOption menuOption;

        do {
            outputWriter.write(menuOptionsOutput);

            ConsoleInput menuOptionInput = inputReader.read();
            menuOption = getMenuOptionForUserInput(menuOptionInput.getInput());

            ConsoleOutput menuActionOutput = menuOption.action(new BookRepository());
            outputWriter.write(menuActionOutput);
        }while(!(menuOption instanceof QuitMenuOption));
    }

    MenuOption getMenuOptionForUserInput(String userInput) {
        return menu.getMenuForOption(userInput);
    }
}
