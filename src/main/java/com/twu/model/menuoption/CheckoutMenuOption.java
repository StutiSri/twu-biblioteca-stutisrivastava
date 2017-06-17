package com.twu.model.menuoption;

import com.twu.biblioteca.BookRepository;
import com.twu.io.input.ConsoleInput;
import com.twu.io.output.ConsoleOutput;

public class CheckoutMenuOption implements MenuOption {
    private final String MENU_OPTION_MESSAGE = "Checkout Book";
    private final String bookToBeCheckedOut;

    public CheckoutMenuOption(String bookToBeCheckedOut) {
        this.bookToBeCheckedOut = bookToBeCheckedOut;
    }

    @Override
    public ConsoleOutput action(BookRepository bookRepository) {
        return null;
    }

    @Override
    public String toString() {
        return MENU_OPTION_MESSAGE;
    }

    @Override
    public boolean equals(Object obj) {
        CheckoutMenuOption checkoutMenuOption = (CheckoutMenuOption)obj;
        return bookToBeCheckedOut.equals(checkoutMenuOption.bookToBeCheckedOut);
    }
}
