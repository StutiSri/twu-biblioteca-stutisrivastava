package com.twu.model.provider;

import com.twu.io.input.ConsoleInput;
import com.twu.io.inputreader.InputReader;
import com.twu.io.output.ConsoleOutput;
import com.twu.io.outputwriter.OutputWriter;
import com.twu.model.menuoption.CheckoutBookMenuOption;
import com.twu.model.menuoption.MenuOption;

public class CheckoutBookMenuOptionProvider implements MenuOptionProvider {

    private final InputReader inputReader;
    private final OutputWriter outputWriter;
    private final String MENU_OPTION_NAME = "Checkout Book";
    private final String MENU_OPTION = "2";

    public CheckoutBookMenuOptionProvider(InputReader inputReader, OutputWriter outputWriter){
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }

    @Override
    public String  getMenuOption() {
        return MENU_OPTION;
    }

    @Override
    public MenuOption getMenu() {
        return new CheckoutBookMenuOption(readBookToBeCheckedOut());
    }

    @Override
    public String getMenuOptionName() {
        return MENU_OPTION_NAME;
    }

    private ConsoleInput readBookToBeCheckedOut() {
        outputWriter.write(new ConsoleOutput("Enter title of the book :- "));
        return inputReader.read();
    }
}
