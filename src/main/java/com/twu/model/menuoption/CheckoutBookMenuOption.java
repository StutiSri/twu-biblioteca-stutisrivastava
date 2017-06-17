package com.twu.model.menuoption;

import com.twu.biblioteca.BookRepository;
import com.twu.io.input.ConsoleInput;
import com.twu.io.output.ConsoleOutput;

public class CheckoutBookMenuOption implements MenuOption {

    private final String titleOfBook;
    private static final String CHECKOUT_FAIL_MESSAGE = "\nThat book is not available.\n";
    private final String CHECKOUT_SUCCESS_MESSAGE = "\nThank you! Enjoy the book.\n";

    public CheckoutBookMenuOption(ConsoleInput bookToBeCheckedOut) {
        this.titleOfBook = bookToBeCheckedOut.getInput();
    }

    @Override
    public ConsoleOutput action(BookRepository bookRepository) {
        if(bookRepository.checkoutBook(titleOfBook))
            return new ConsoleOutput(CHECKOUT_SUCCESS_MESSAGE);
        return new ConsoleOutput(CHECKOUT_FAIL_MESSAGE);
    }

    @Override
    public boolean equals(Object obj) {
        CheckoutBookMenuOption checkoutBookMenuOption = (CheckoutBookMenuOption)obj;
        return titleOfBook.equals(checkoutBookMenuOption.titleOfBook);
    }
}
