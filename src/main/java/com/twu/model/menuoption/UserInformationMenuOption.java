package com.twu.model.menuoption;

import com.twu.io.output.ConsoleOutput;
import com.twu.model.user.Customer;

public class UserInformationMenuOption implements MenuOption {
    private final String MENU_OPTION_NAME = "My Account";

    public UserInformationMenuOption(Customer loggedInUser) {
    }

    @Override
    public ConsoleOutput action() {
        return null;
    }

    @Override
    public String getMenuOptionName() {
        return MENU_OPTION_NAME;
    }
}
