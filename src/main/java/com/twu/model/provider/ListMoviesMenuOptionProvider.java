package com.twu.model.provider;

import com.twu.model.menuoption.ListMoviesMenuOption;
import com.twu.model.menuoption.MenuOption;
import com.twu.model.repository.Repository;

public class ListMoviesMenuOptionProvider implements MenuOptionProvider {
    private final String MENU_OPTION_NAME = "List Movies";
    private final Repository movieRepository;
    private String MENU_OPTION = "4";

    public ListMoviesMenuOptionProvider(Repository movieRepository) {

        this.movieRepository = movieRepository;
    }

    @Override
    public String getMenuOption() {
        return MENU_OPTION;
    }

    @Override
    public MenuOption getMenu() {
        return new ListMoviesMenuOption(movieRepository);
    }

    @Override
    public String getMenuOptionName() {
        return MENU_OPTION_NAME;
    }
}
