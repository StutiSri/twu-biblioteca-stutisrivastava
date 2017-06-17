package com.twu.model.menuoption;

import com.twu.biblioteca.BookRepository;
import com.twu.io.output.ConsoleOutput;

public class CheckoutMenuOption implements MenuOption {

    private final String bookToBeCheckedOut;
    private static final String CHECKOUT_FAIL_MESSAGE = "\nThat book is not available.\n";
    private final String CHECKOUT_SUCCESS_MESSAGE = "\nThank you! Enjoy the book.\n";

    public CheckoutMenuOption(String bookToBeCheckedOut) {
        this.bookToBeCheckedOut = bookToBeCheckedOut;
    }

    @Override
    public ConsoleOutput action(BookRepository bookRepository) {
        if(bookRepository.checkoutBook(bookToBeCheckedOut))
            return new ConsoleOutput(CHECKOUT_SUCCESS_MESSAGE);
        return new ConsoleOutput(CHECKOUT_FAIL_MESSAGE);
    }

    @Override
    public boolean equals(Object obj) {
        CheckoutMenuOption checkoutMenuOption = (CheckoutMenuOption)obj;
        return bookToBeCheckedOut.equals(checkoutMenuOption.bookToBeCheckedOut);
    }
}
