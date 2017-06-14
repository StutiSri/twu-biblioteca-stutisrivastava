package com.twu.model.menuoption;

import com.twu.output.Output;

public class ListBooksMenuOption implements MenuOption {

    public static final String MENU_OPTION = "List Books";

    @Override
    public Output action() {
        return null;
    }

    @Override
    public String toString() {
        return MENU_OPTION;
    }
}
