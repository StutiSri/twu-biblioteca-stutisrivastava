package com.twu.biblioteca;

import com.twu.exception.InvalidLoginException;
import com.twu.io.input.ConsoleInput;
import com.twu.io.inputreader.InputReader;
import com.twu.io.output.ConsoleOutput;
import com.twu.io.outputwriter.OutputWriter;
import com.twu.model.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserLogin {

    private final InputReader inputReader;
    private final OutputWriter outputWriter;

    private final String MESSAGE_FOR_LOGIN_DETAILS = "Enter login details:-\n";
    private final String LIBRARY_NUMBER = "\tLibrary Number : ";
    private final String PASSWORD = "\tPassword : ";

    List<User> users;
    private String MESSAGE_FOR_USER_NAME;

    public UserLogin(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;

        users = new ArrayList<>();
        users.add(new User("Stuti", "STU-9176", "stuti@gmail.com", "9176835429", "password"));
    }

    public User login() throws InvalidLoginException {
        outputWriter.write(new ConsoleOutput(MESSAGE_FOR_LOGIN_DETAILS + LIBRARY_NUMBER));
        ConsoleInput libraryNumberInput = inputReader.read();

        outputWriter.write(new ConsoleOutput(PASSWORD));
        ConsoleInput passwordInput = inputReader.read();

        for(User user : users){
            if(user.getLibraryNumber().equals(libraryNumberInput.getInput())
                    && user.getPassword().equals(passwordInput.getInput()))
                return user;
        }
        throw new InvalidLoginException();
    }
}
