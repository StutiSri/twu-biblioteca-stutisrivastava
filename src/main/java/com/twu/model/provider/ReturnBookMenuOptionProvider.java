package com.twu.model.provider;

import com.twu.io.input.ConsoleInput;
import com.twu.io.inputreader.InputReader;
import com.twu.io.output.ConsoleOutput;
import com.twu.io.outputwriter.OutputWriter;
import com.twu.model.menuoption.MenuOption;
import com.twu.model.menuoption.ReturnBookMenuOption;

public class ReturnBookMenuOptionProvider implements MenuOptionProvider {

    private final String MENU_OPTION_NAME = "Return Book";
    private InputReader inputReader;
    private OutputWriter outputWriter;
    private String menuOption;

    public ReturnBookMenuOptionProvider(InputReader inputReader, OutputWriter outputWriter){
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        menuOption = "3";
    }

    @Override
    public String  getMenuOption() {
        return menuOption;
    }

    @Override
    public MenuOption getMenu() {
        return new ReturnBookMenuOption(getBookToBeReturned());
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
