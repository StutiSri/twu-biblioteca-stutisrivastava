package com.twu.model.menuoption;

import com.twu.biblioteca.BookRepository;
import com.twu.io.input.ConsoleInput;
import com.twu.io.output.ConsoleOutput;

public class ReturnBookMenuOption implements MenuOption {

    private final String titleOfBook;
    private final String RETURN_SUCCESSFUL_MESSAGE = "\nThank you for returning the book.\n";
    private static final String RETURN_UNSUCCESSFUL_MESSAGE = "\nThat is not a valid book to return.\n";

    public ReturnBookMenuOption(ConsoleInput bookToBeReturned) {
        titleOfBook = bookToBeReturned.getInput();
    }

    @Override
    public ConsoleOutput action(BookRepository bookRepository) {
        if(bookRepository.returnBook(titleOfBook))
            return new ConsoleOutput(RETURN_SUCCESSFUL_MESSAGE);
        return new ConsoleOutput(RETURN_UNSUCCESSFUL_MESSAGE);
    }
}
