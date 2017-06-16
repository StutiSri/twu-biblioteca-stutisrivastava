package com.twu.model.provider;

import com.twu.model.menuoption.CheckoutMenuOption;
import com.twu.model.menuoption.MenuOption;

public class CheckoutMenuOptionProvider implements MenuOptionProvider {

    private String menuOption;

    public CheckoutMenuOptionProvider(){
        menuOption = "2";
    }

    @Override
    public String  getMenuOption() {
        return menuOption;
    }

    @Override
    public MenuOption getMenu() {
        return new CheckoutMenuOption();
    }
}
