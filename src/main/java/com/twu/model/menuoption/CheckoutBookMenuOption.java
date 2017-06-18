package com.twu.model.menuoption;

import com.twu.io.input.ConsoleInput;
import com.twu.io.output.ConsoleOutput;
import com.twu.model.repository.Repository;

public class CheckoutBookMenuOption implements MenuOption {

    private final Repository repository;
    private final String titleOfBook;
    private static final String CHECKOUT_FAIL_MESSAGE = "\nThat book is not available.\n";
    private final String CHECKOUT_SUCCESS_MESSAGE = "\nThank you! Enjoy the book.\n";

    public CheckoutBookMenuOption(Repository bookRepository, ConsoleInput bookToBeCheckedOut) {
        this.repository = bookRepository;
        this.titleOfBook = bookToBeCheckedOut.getInput();
    }

    @Override
    public ConsoleOutput action() {
        if(repository.checkoutArtifact(titleOfBook))
            return new ConsoleOutput(CHECKOUT_SUCCESS_MESSAGE);
        return new ConsoleOutput(CHECKOUT_FAIL_MESSAGE);
    }

    @Override
    public boolean equals(Object obj) {
        CheckoutBookMenuOption checkoutBookMenuOption = (CheckoutBookMenuOption)obj;
        return titleOfBook.equals(checkoutBookMenuOption.titleOfBook);
    }
}
