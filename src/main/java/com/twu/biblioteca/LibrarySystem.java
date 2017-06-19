package com.twu.biblioteca;

import com.twu.io.InputOutputHandler;
import com.twu.io.input.ConsoleInput;
import com.twu.io.inputreader.InputReader;
import com.twu.io.output.ConsoleOutput;
import com.twu.io.outputwriter.OutputWriter;
import com.twu.model.menu.GeneralMenu;
import com.twu.model.menu.Menu;
import com.twu.model.menu.UserMenu;
import com.twu.model.menuoption.MenuOption;
import com.twu.model.menuoption.QuitMenuOption;
import com.twu.model.repository.BookRepository;
import com.twu.model.repository.LibraryRepository;
import com.twu.model.repository.MovieRepository;
import com.twu.model.user.Customer;

public class LibrarySystem {

    private static final String WELCOME_MESSAGE = "Hello Customer! Welcome to " +
            "Biblioteca! :)\n";
    private Customer loggedInUser;
    private InputOutputHandler inputOutputHandler;
    private Menu menu;

    public LibrarySystem(InputOutputHandler inputOutputHandler) {
        this.inputOutputHandler = inputOutputHandler;
        menu = new GeneralMenu(inputOutputHandler, new LibraryRepository(), loggedInUser);
    }

    public void run() {
        ConsoleOutput welcomeMessage = new ConsoleOutput(WELCOME_MESSAGE);
        inputOutputHandler.writeOutput(welcomeMessage);

        ConsoleOutput menuOptionsOutput = menu.getMenuOptions();
        MenuOption menuOption;

        do{
            inputOutputHandler.writeOutput(menuOptionsOutput);

            String menuOptionInput = inputOutputHandler.readInput();
            menuOption = getMenuOptionForUserInput(menuOptionInput);

            ConsoleOutput menuActionOutput = menuOption.action();
            inputOutputHandler.writeOutput(menuActionOutput);

        }while(!(menuOption instanceof QuitMenuOption));
    }

    private MenuOption getMenuOptionForUserInput(String userInput) {
        return menu.getMenuForOption(userInput);
    }
}
