package com.twu.model.provider;

import com.twu.model.menuoption.MenuOption;
import com.twu.model.menuoption.ReturnBookMenuOption;

public class ReturnBookMenuOptionProvider implements MenuOptionProvider {

    private final String MENU_OPTION_NAME = "Return Book";
    private String menuOption;

    public ReturnBookMenuOptionProvider(){
        menuOption = "3";
    }

    @Override
    public String  getMenuOption() {
        return menuOption;
    }

    @Override
    public MenuOption getMenu() {
        return new ReturnBookMenuOption();
    }

    @Override
    public String getMenuOptionName() {
        return MENU_OPTION_NAME;
    }
}
