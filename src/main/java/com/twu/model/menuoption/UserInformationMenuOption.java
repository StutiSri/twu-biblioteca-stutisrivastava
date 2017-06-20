package com.twu.model.menuoption;

import com.twu.io.output.ConsoleOutput;
import com.twu.model.user.Customer;

public class UserInformationMenuOption implements MenuOption {
    private final String MENU_OPTION_NAME = "My Account";
    private final Customer loggedInUser;

    public UserInformationMenuOption(Customer loggedInUser) {

        this.loggedInUser = loggedInUser;
    }

    @Override
    public ConsoleOutput action() {
        return new ConsoleOutput(loggedInUser.getDetails());
    }

    @Override
    public String getMenuOptionName() {
        return MENU_OPTION_NAME;
    }
}
