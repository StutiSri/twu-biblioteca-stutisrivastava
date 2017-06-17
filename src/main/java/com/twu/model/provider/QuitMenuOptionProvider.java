package com.twu.model.provider;


import com.twu.model.menuoption.MenuOption;
import com.twu.model.menuoption.QuitMenuOption;

public class QuitMenuOptionProvider implements MenuOptionProvider {

    private final String MENU_OPTION_MESSAGE = "Quit";
    private final String MENU_OPTION = "6";

    @Override
    public String getMenuOption() {
        return MENU_OPTION;
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
