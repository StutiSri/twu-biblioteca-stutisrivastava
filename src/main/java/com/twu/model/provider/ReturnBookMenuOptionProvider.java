package com.twu.model.provider;

import com.twu.io.input.ConsoleInput;
import com.twu.io.inputreader.InputReader;
import com.twu.io.output.ConsoleOutput;
import com.twu.io.outputwriter.OutputWriter;
import com.twu.model.menuoption.MenuOption;
import com.twu.model.menuoption.ReturnBookMenuOption;
import com.twu.model.repository.Repository;

public class ReturnBookMenuOptionProvider implements MenuOptionProvider {

    private final String MENU_OPTION_NAME = "Return Book";
    private InputReader inputReader;
    private OutputWriter outputWriter;
    private final Repository bookRepository;
    private final String MENU_OPTION = "3";

    public ReturnBookMenuOptionProvider(InputReader inputReader, OutputWriter outputWriter, Repository bookRepository){
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.bookRepository = bookRepository;
    }

    @Override
    public String  getMenuOption() {
        return MENU_OPTION;
    }

    @Override
    public MenuOption getMenu() {
        return new ReturnBookMenuOption(bookRepository, getBookToBeReturned());
    }

    @Override
    public String getMenuOptionName() {
        return MENU_OPTION_NAME;
    }

    public ConsoleInput getBookToBeReturned() {
        outputWriter.write(new ConsoleOutput("Enter title of book to be returned :- "));
        return inputReader.read();
    }
}
