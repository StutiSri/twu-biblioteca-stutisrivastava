package com.twu.model.menuoption;

import com.twu.biblioteca.UserLogin;
import com.twu.exception.InvalidLoginException;
import com.twu.io.InputOutputHandler;
import com.twu.io.output.ConsoleOutput;
import com.twu.model.user.Customer;

public class LoginMenuOption implements MenuOption{
    private final String LOGIN_SUCCESSFUL_MESSAGE = "\nLogin successful.";
    private InputOutputHandler inputOutputHandler;
    private final String MENU_OPTION_NAME = "Login to checkout and return";

    public LoginMenuOption(InputOutputHandler inputOutputHandler) {
        this.inputOutputHandler = inputOutputHandler;
    }

    @Override
    public ConsoleOutput action() {
        UserLogin userLogin = new UserLogin(inputOutputHandler);
        try {
            userLogin.login();
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
