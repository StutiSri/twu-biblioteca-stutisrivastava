package com.twu.model.menuoption;

import com.twu.io.InputOutputHandler;
import com.twu.io.output.ConsoleOutput;
import com.twu.model.repository.LibraryRepository;
import com.twu.model.user.Customer;

public class CheckoutMovieMenuOption implements MenuOption {
    private final InputOutputHandler inputOutputHandler;
    private final LibraryRepository libraryRepository;
    private final Customer loggedInUser;
    private static final String CHECKOUT_FAIL_MESSAGE = "\nThat movie is not available.\n";
    private final String CHECKOUT_SUCCESS_MESSAGE = "\nThank you! Enjoy the movie.\n";
    private final String MENU_OPTION_NAME = "Checkout Movie";

    public CheckoutMovieMenuOption(InputOutputHandler inputOutputHandler, LibraryRepository libraryRepository, Customer loggedInUser) {
        this.inputOutputHandler = inputOutputHandler;
        this.libraryRepository = libraryRepository;
        this.loggedInUser = loggedInUser;
    }

    @Override
    public ConsoleOutput action() {
        String titleOfMovie = readMovieToBeCheckedOut();
        if (libraryRepository.checkoutMovie(titleOfMovie, loggedInUser) != null)
            return new ConsoleOutput(CHECKOUT_SUCCESS_MESSAGE);
        return new ConsoleOutput(CHECKOUT_FAIL_MESSAGE);
    }

    @Override
    public String getMenuOptionName() {
        return MENU_OPTION_NAME;
    }

    private String readMovieToBeCheckedOut() {
        inputOutputHandler.writeOutput(new ConsoleOutput("Enter title of the movie :- "));
        return inputOutputHandler.readInput();
    }
}
