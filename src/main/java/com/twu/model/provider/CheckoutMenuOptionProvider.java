package com.twu.model.provider;

import com.twu.io.inputreader.InputReader;
import com.twu.model.menuoption.CheckoutMenuOption;
import com.twu.model.menuoption.MenuOption;

public class CheckoutMenuOptionProvider implements MenuOptionProvider {

    private final InputReader inputReader;
    private String menuOption;
    private final String MENU_OPTION_NAME = "Checkout Book";

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

    @Override
    public String getMenuOptionName() {
        return MENU_OPTION_NAME;
    }

    private String readBookToBeCheckedOut() {
        return inputReader.read().getInput();
    }
}
