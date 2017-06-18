package com.twu.model.menuoption;

import com.twu.biblioteca.UserLogin;
import com.twu.exception.InvalidLoginException;
import com.twu.io.inputreader.InputReader;
import com.twu.io.output.ConsoleOutput;
import com.twu.io.outputwriter.OutputWriter;
import com.twu.model.user.User;

public class LoginMenuOption implements MenuOption{
    private final String LOGIN_SUCCESSFUL_MESSAGE = "\nLogin succesful.\n";
    private final InputReader inputReader;
    private final OutputWriter outputWriter;
    private User loggedInUser;

    public LoginMenuOption(InputReader inputReader, OutputWriter outputWriter, User loggedInUser) {

        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.loggedInUser = loggedInUser;
    }

    @Override
    public ConsoleOutput action() {
        UserLogin userLogin = new UserLogin(inputReader, outputWriter);
        try {
            loggedInUser = userLogin.login();
            return new ConsoleOutput(LOGIN_SUCCESSFUL_MESSAGE);
        } catch (InvalidLoginException e) {
            return new ConsoleOutput(e.getMessage());
        }
    }
}
