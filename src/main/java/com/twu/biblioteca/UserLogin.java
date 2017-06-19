package com.twu.biblioteca;

import com.twu.exception.InvalidLoginException;
import com.twu.exception.InvalidLogoutException;
import com.twu.io.InputOutputHandler;
import com.twu.io.output.ConsoleOutput;
import com.twu.model.user.Customer;
import com.twu.model.user.LibraryUser;
import com.twu.model.user.UserType;

import java.util.ArrayList;
import java.util.List;

public class UserLogin {

    private final String MESSAGE_FOR_LOGIN_DETAILS = "Enter login details:-\n";
    private final String LIBRARY_NUMBER = "\tLibrary Number : ";
    private final String PASSWORD = "\tPassword : ";
    private InputOutputHandler inputOutputHandler;

    List<LibraryUser> users;

    static LibraryUser loggedInUser;

    public UserLogin(InputOutputHandler inputOutputHandler) {
        this.inputOutputHandler = inputOutputHandler;
        users = new ArrayList<>();
        users.add(new Customer("Stuti", "STU-9176", "stuti@gmail.com", "9176835429", "password"));
        users.add(new LibraryUser("LIB-9176", "password", UserType.LIBRARIAN));
    }

    public LibraryUser login() throws InvalidLoginException {
        inputOutputHandler.writeOutput(new ConsoleOutput(MESSAGE_FOR_LOGIN_DETAILS + LIBRARY_NUMBER));
        String libraryNumberInput = inputOutputHandler.readInput();

        inputOutputHandler.writeOutput(new ConsoleOutput(PASSWORD));
        String passwordInput = inputOutputHandler.readInput();

        for(LibraryUser user : users){
            if(user.verifyCredentials(libraryNumberInput, passwordInput)) {
                loggedInUser = user;
                return user;
            }
        }
        throw new InvalidLoginException();
    }

    public static LibraryUser getLoggedInUser() {
        return loggedInUser;
    }

    public boolean logout() throws InvalidLogoutException {
        if(loggedInUser == null)
            throw new InvalidLogoutException();
        loggedInUser = null;
        return true;
    }
}
