package com.twu.model.menuoption;

import com.twu.output.Output;

public class QuitMenuOption implements MenuOption {
    private static final String MENU_OPTION = "Quit";

    @Override
    public String toString() {
        return MENU_OPTION;
    }
}
