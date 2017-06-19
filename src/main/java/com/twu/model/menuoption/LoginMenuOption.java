package com.twu.model.menuoption;

import com.twu.biblioteca.UserLogin;
import com.twu.exception.InvalidLoginException;
import com.twu.io.InputOutputHandler;
import com.twu.io.inputreader.InputReader;
import com.twu.io.output.ConsoleOutput;
import com.twu.io.outputwriter.OutputWriter;
import com.twu.model.user.Customer;

public class LoginMenuOption implements MenuOption{
    private final String LOGIN_SUCCESSFUL_MESSAGE = "\nLogin successful.";
    private InputReader inputReader;
    private OutputWriter outputWriter;
    private InputOutputHandler inputOutputHandler;
    private Customer loggedInUser;
    private final String MENU_OPTION_NAME = "Login to checkout and return";

    public LoginMenuOption(InputReader inputReader, OutputWriter outputWriter, Customer loggedInUser) {

        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.loggedInUser = loggedInUser;
    }

    public LoginMenuOption(InputOutputHandler inputOutputHandler, Customer loggedInUser) {
        this.inputOutputHandler = inputOutputHandler;
        this.loggedInUser = loggedInUser;
    }

    @Override
    public ConsoleOutput action() {
        UserLogin userLogin = new UserLogin(inputOutputHandler);
        try {
            loggedInUser = userLogin.login();
            return new ConsoleOutput(LOGIN_SUCCESSFUL_MESSAGE);
        } catch (InvalidLoginException e) {
            return new ConsoleOutput(e.getMessage());
        }
    }

    @Override
    public String getMenuOptionName() {
        return MENU_OPTION_NAME;
    }
}
