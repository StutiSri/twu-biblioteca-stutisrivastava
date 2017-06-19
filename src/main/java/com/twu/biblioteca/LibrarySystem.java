package com.twu.biblioteca;

import com.twu.io.InputOutputHandler;
import com.twu.io.output.ConsoleOutput;
import com.twu.model.menu.Menu;
import com.twu.model.menuoption.MenuOption;
import com.twu.model.menuoption.QuitMenuOption;
import com.twu.model.menuprovider.MenuProvider;
import com.twu.model.repository.LibraryRepository;
import com.twu.model.user.Customer;

public class LibrarySystem {

    private static final String WELCOME_MESSAGE = "Hello Customer! Welcome to " +
            "Biblioteca! :)\n";
    private final MenuProvider menuProvider;
    private Customer loggedInUser;
    private InputOutputHandler inputOutputHandler;
    private Menu menu;

    public LibrarySystem(InputOutputHandler inputOutputHandler) {
        this.inputOutputHandler = inputOutputHandler;
        menuProvider = new MenuProvider(inputOutputHandler, new LibraryRepository());
    }

    public void run() {
        ConsoleOutput welcomeMessage = new ConsoleOutput(WELCOME_MESSAGE);
        inputOutputHandler.writeOutput(welcomeMessage);

        MenuOption menuOption;

        do{
            menu = menuProvider.getMenu();
            ConsoleOutput menuOptionsOutput = menu.getMenuOptions();
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
