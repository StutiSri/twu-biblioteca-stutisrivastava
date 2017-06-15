package com.twu.model.provider;


import com.twu.model.menuoption.MenuOption;
import com.twu.model.menuoption.QuitMenuOption;

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
        return new QuitMenuOption();
    }
}
