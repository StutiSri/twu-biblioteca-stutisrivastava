package com.twu.model.provider;

import com.twu.model.menuoption.ListBooksMenuOption;
import com.twu.model.menuoption.ListMoviesMenuOption;
import com.twu.model.menuoption.MenuOption;

public class ListMoviesMenuOptionProvider implements MenuOptionProvider {
    private final String MENU_OPTION_NAME = "List Movies";
    private String MENU_OPTION = "4";

    @Override
    public String getMenuOption() {
        return MENU_OPTION;
    }

    @Override
    public MenuOption getMenu() {
        return new ListMoviesMenuOption();
    }

    @Override
    public String getMenuOptionName() {
        return MENU_OPTION_NAME;
    }
}
