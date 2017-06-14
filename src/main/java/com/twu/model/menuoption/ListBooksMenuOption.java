package com.twu.model.menuoption;

import com.twu.output.Output;

public class ListBooksMenuOption implements MenuOption {

    public static final String MENU_OPTION = "List Books";

    @Override
    public String toString() {
        return MENU_OPTION;
    }
}
