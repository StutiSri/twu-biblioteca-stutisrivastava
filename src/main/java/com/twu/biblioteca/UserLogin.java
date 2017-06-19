package com.twu.biblioteca;

import com.twu.exception.InvalidLoginException;
import com.twu.io.InputOutputHandler;
import com.twu.io.input.ConsoleInput;
import com.twu.io.inputreader.InputReader;
import com.twu.io.output.ConsoleOutput;
import com.twu.io.outputwriter.OutputWriter;
import com.twu.model.user.Customer;

import java.util.ArrayList;
import java.util.List;

public class UserLogin {

    private final String MESSAGE_FOR_LOGIN_DETAILS = "Enter login details:-\n";
    private final String LIBRARY_NUMBER = "\tLibrary Number : ";
    private final String PASSWORD = "\tPassword : ";
    private InputOutputHandler inputOutputHandler;

    List<Customer> users;

    public UserLogin(InputOutputHandler inputOutputHandler) {

        this.inputOutputHandler = inputOutputHandler;
        users = new ArrayList<>();
        users.add(new Customer("Stuti", "STU-9176", "stuti@gmail.com", "9176835429", "password"));
    }

    public Customer login() throws InvalidLoginException {
        inputOutputHandler.writeOutput(new ConsoleOutput(MESSAGE_FOR_LOGIN_DETAILS + LIBRARY_NUMBER));
        String libraryNumberInput = inputOutputHandler.readInput();

        inputOutputHandler.writeOutput(new ConsoleOutput(PASSWORD));
        String passwordInput = inputOutputHandler.readInput();

        for(Customer user : users){
            if(user.getLibraryNumber().equals(libraryNumberInput)
                    && user.getPassword().equals(passwordInput))
                return user;
        }
        throw new InvalidLoginException();
    }
}
