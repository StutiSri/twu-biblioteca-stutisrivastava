package com.twu.biblioteca;

import com.twu.io.input.ConsoleInput;
import com.twu.io.inputreader.InputReader;
import com.twu.io.output.ConsoleOutput;
import com.twu.io.outputwriter.OutputWriter;
import com.twu.model.menuoption.MenuOption;
import com.twu.model.menuoption.QuitMenuOption;
import com.twu.model.repository.BookRepository;
import com.twu.model.repository.MovieRepository;
import com.twu.model.repository.Repository;
import com.twu.model.user.User;

public class LibrarySystem {

    private static final String WELCOME_MESSAGE = "Hello User! Welcome to " +
            "Biblioteca! :)\n";
    private final User loggedInUser;
    private InputReader inputReader;
    private OutputWriter outputWriter;
    private Menu menu;

    public LibrarySystem(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        loggedInUser = null;
        menu = new Menu(inputReader, outputWriter,
                new BookRepository(), new MovieRepository(), loggedInUser);
    }

    public void run() {
        ConsoleOutput welcomeMessage = new ConsoleOutput(WELCOME_MESSAGE);
        outputWriter.write(welcomeMessage);

        ConsoleOutput menuOptionsOutput = menu.getMenuOptions();
        MenuOption menuOption;

        do{
            outputWriter.write(menuOptionsOutput);

            ConsoleInput menuOptionInput = inputReader.read();
            menuOption = getMenuOptionForUserInput(menuOptionInput.getInput());

            ConsoleOutput menuActionOutput = menuOption.action();
            outputWriter.write(menuActionOutput);

        }while(!(menuOption instanceof QuitMenuOption));
    }

    private MenuOption getMenuOptionForUserInput(String userInput) {
        return menu.getMenuForOption(userInput);
    }
}
