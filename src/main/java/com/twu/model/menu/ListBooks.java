package com.twu.model.menu;

import com.twu.output.Output;

public class ListBooks implements Menu {

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
