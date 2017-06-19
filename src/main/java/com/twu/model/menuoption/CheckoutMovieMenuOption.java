package com.twu.model.menuoption;

import com.twu.io.input.ConsoleInput;
import com.twu.io.output.ConsoleOutput;
import com.twu.model.repository.Repository;

public class CheckoutMovieMenuOption implements MenuOption{
    private Repository repository;
    private String titleOfMovie;
    private static final String CHECKOUT_FAIL_MESSAGE = "\nThat movie is not available.\n";
    private final String CHECKOUT_SUCCESS_MESSAGE = "\nThank you! Enjoy the movie.\n";

    public CheckoutMovieMenuOption(Repository movieRepository, ConsoleInput movieToBeCheckedOut) {
        this.repository = movieRepository;
        this.titleOfMovie = movieToBeCheckedOut.getInput();
    }

    @Override
    public ConsoleOutput action() {
        if(repository.checkoutArtifact(titleOfMovie))
            return new ConsoleOutput(CHECKOUT_SUCCESS_MESSAGE);
        return new ConsoleOutput(CHECKOUT_FAIL_MESSAGE);
    }
}
