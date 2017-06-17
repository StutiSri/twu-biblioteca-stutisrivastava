package com.twu.model.provider;

import com.twu.model.menuoption.ListBooksMenuOption;
import com.twu.model.menuoption.MenuOption;

public class ListBookMenuOptionProvider implements MenuOptionProvider {

    private final String MENU_OPTION_NAME = "List Books";
    private String menuOption;

    public ListBookMenuOptionProvider(){
        menuOption = "1";
    }

    @Override
    public String  getMenuOption() {
        return menuOption;
    }

    @Override
    public MenuOption getMenu() {
        return new ListBooksMenuOption();
    }

    @Override
    public String getMenuOptionName() {
        return MENU_OPTION_NAME;
    }
}
