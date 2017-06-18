package com.twu.model.provider;

import com.twu.model.menuoption.ListBooksMenuOption;
import com.twu.model.menuoption.MenuOption;
import com.twu.model.repository.Repository;

public class ListBookMenuOptionProvider implements MenuOptionProvider {

    private final String MENU_OPTION_NAME = "List Books";
    private final String MENU_OPTION = "1";
    private final Repository bookRepository;

    public ListBookMenuOptionProvider(Repository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public String  getMenuOption() {
        return MENU_OPTION;
    }

    @Override
    public MenuOption getMenu() {
        return new ListBooksMenuOption(bookRepository);
    }

    @Override
    public String getMenuOptionName() {
        return MENU_OPTION_NAME;
    }
}
