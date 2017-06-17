package com.twu.model.provider;

import com.twu.io.input.ConsoleInput;
import com.twu.io.inputreader.InputReader;
import com.twu.model.menuoption.CheckoutMenuOption;
import com.twu.model.menuoption.MenuOption;

public class CheckoutMenuOptionProvider implements MenuOptionProvider {

    private final InputReader inputReader;
    private String menuOption;

    public CheckoutMenuOptionProvider(InputReader InputReader){
        inputReader = InputReader;
        menuOption = "2";
    }

    @Override
    public String  getMenuOption() {
        return menuOption;
    }

    @Override
    public MenuOption getMenu() {
        return new CheckoutMenuOption(readBookToBeCheckedOut());
    }

    private String readBookToBeCheckedOut() {
        return inputReader.read().getInput();
    }
}
