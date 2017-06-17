package com.twu.model.provider;

import com.twu.model.menuoption.MenuOption;

public interface MenuOptionProvider {
    String getMenuOption();

    MenuOption getMenu();

    String getMenuOptionName();
}
