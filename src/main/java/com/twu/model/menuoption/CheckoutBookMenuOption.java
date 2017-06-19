package com.twu.model.menuoption;

import com.twu.io.InputOutputHandler;
import com.twu.io.output.ConsoleOutput;
import com.twu.model.repository.LibraryRepository;
import com.twu.model.user.Customer;

public class CheckoutBookMenuOption implements MenuOption {

    private final InputOutputHandler inputOutputHandler;
    private LibraryRepository repository;
    private final Customer loggedInUser;
    private static final String CHECKOUT_FAIL_MESSAGE = "\nThat book is not available.\n";
    private final String CHECKOUT_SUCCESS_MESSAGE = "\nThank you! Enjoy the book.\n";
    private final String MENU_OPTION_NAME = "Checkout Book";

    public CheckoutBookMenuOption(InputOutputHandler inputOutputHandler, LibraryRepository repository, Customer loggedInUser) {

        this.inputOutputHandler = inputOutputHandler;
        this.repository = repository;
        this.loggedInUser = loggedInUser;
    }

    @Override
    public ConsoleOutput action() {
        String titleOfBook = readBookToBeCheckedOut();
        if(repository.checkoutBook(titleOfBook, loggedInUser)!=null)
            return new ConsoleOutput(CHECKOUT_SUCCESS_MESSAGE);
        return new ConsoleOutput(CHECKOUT_FAIL_MESSAGE);
    }

    @Override
    public String getMenuOptionName() {
        return MENU_OPTION_NAME;
    }

    private String readBookToBeCheckedOut() {
        inputOutputHandler.writeOutput(new ConsoleOutput("Enter title of the book :- "));
        return inputOutputHandler.readInput();
    }

}
