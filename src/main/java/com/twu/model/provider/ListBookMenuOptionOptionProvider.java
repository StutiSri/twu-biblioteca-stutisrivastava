package com.twu.model.provider;

import com.twu.model.menuoption.ListBooksMenuOption;
import com.twu.model.menuoption.MenuOption;

public class ListBookMenuOptionOptionProvider implements MenuOptionProvider {
    private String menuOption;

    public ListBookMenuOptionOptionProvider(){
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
}
