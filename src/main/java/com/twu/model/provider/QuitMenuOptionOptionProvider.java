package com.twu.model.provider;

import com.twu.model.menuoption.MenuOption;

public class QuitMenuOptionOptionProvider implements MenuOptionProvider {

    private String menuOption;

    public QuitMenuOptionOptionProvider() {
        this.menuOption = "2";
    }

    @Override
    public String getMenuOption() {
        return menuOption;
    }

    @Override
    public MenuOption getMenu() {
        return null;
    }
}
