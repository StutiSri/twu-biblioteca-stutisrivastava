package com.twu.model.menuoption;

import com.twu.io.input.ConsoleInput;
import com.twu.io.output.ConsoleOutput;
import com.twu.model.repository.Repository;

public class ReturnBookMenuOption implements MenuOption {

    private final String titleOfBook;
    private final String RETURN_SUCCESSFUL_MESSAGE = "\nThank you for returning the book.\n";
    private static final String RETURN_UNSUCCESSFUL_MESSAGE = "\nThat is not a valid book to return.\n";
    private final Repository repository;

    public ReturnBookMenuOption(Repository bookRepository, ConsoleInput bookToBeReturned) {
        titleOfBook = bookToBeReturned.getInput();
        repository = bookRepository;
    }

    @Override
    public ConsoleOutput action() {
        if(repository.returnArtifact(titleOfBook))
            return new ConsoleOutput(RETURN_SUCCESSFUL_MESSAGE);
        return new ConsoleOutput(RETURN_UNSUCCESSFUL_MESSAGE);
    }
}
