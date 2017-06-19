package com.twu.model.menuoption;

import com.twu.io.InputOutputHandler;
import com.twu.io.output.ConsoleOutput;
import com.twu.model.repository.LibraryRepository;

public class ReturnBookMenuOption implements MenuOption {

    private final InputOutputHandler inputOutputHandler;
    private final LibraryRepository libraryRepository;
    private String titleOfBook;
    private final String MENU_OPTION_NAME = "Return Book";
    private final String RETURN_SUCCESSFUL_MESSAGE = "\nThank you for returning the book.\n";
    private static final String RETURN_UNSUCCESSFUL_MESSAGE = "\nThat is not a valid book to return.\n";

    public ReturnBookMenuOption(InputOutputHandler inputOutputHandler, LibraryRepository libraryRepository) {
        this.inputOutputHandler = inputOutputHandler;
        this.libraryRepository = libraryRepository;
    }

    @Override
    public ConsoleOutput action() {
        if(libraryRepository.returnBook(titleOfBook))
            return new ConsoleOutput(RETURN_SUCCESSFUL_MESSAGE);
        return new ConsoleOutput(RETURN_UNSUCCESSFUL_MESSAGE);
    }

    @Override
    public String getMenuOptionName() {
        return MENU_OPTION_NAME;
    }
}
