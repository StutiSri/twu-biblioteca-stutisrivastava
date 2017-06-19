package com.twu.model.provider;

import com.twu.model.menuoption.MenuOption;
import com.twu.model.user.User;

public class UserInformationMenuOptionProvider implements MenuOptionProvider {

    private final String MENU_OPTION_NAME = "User Information";
    private final String MENU_OPTION = "6";
    private final User loggedInUser;

    public UserInformationMenuOptionProvider(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    @Override
    public String getMenuOption() {
        return MENU_OPTION;
    }

    @Override
    public MenuOption getMenu() {
        return null;
    }

    @Override
    public String getMenuOptionName() {
        return MENU_OPTION_NAME;
    }
}
