package com.twu.model.provider;

import com.twu.model.menuoption.ListBooksMenuOption;
import com.twu.model.menuoption.MenuOption;

public class ListBookMenuOptionProvider implements MenuOptionProvider {
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
}
