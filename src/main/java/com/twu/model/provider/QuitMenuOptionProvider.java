package com.twu.model.provider;


import com.twu.model.menuoption.MenuOption;
import com.twu.model.menuoption.QuitMenuOption;

public class QuitMenuOptionProvider implements MenuOptionProvider {

    private final String MENU_OPTION_MESSAGE = "Quit";
    private String menuOption;

    public QuitMenuOptionProvider() {
        this.menuOption = "4";
    }

    @Override
    public String getMenuOption() {
        return menuOption;
    }

    @Override
    public MenuOption getMenu() {
        return new QuitMenuOption();
    }

    @Override
    public String getMenuOptionName() {
        return MENU_OPTION_MESSAGE;
    }
}
