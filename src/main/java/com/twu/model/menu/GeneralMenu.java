package com.twu.model.menu;

import com.twu.io.InputOutputHandler;
import com.twu.io.output.ConsoleOutput;
import com.twu.model.menuoption.*;
import com.twu.model.repository.LibraryRepository;
import com.twu.model.user.Customer;

import java.util.LinkedHashMap;
import java.util.Map;

public class GeneralMenu extends Menu{
    private Map<String, MenuOption> menuOptionProviders;

    public GeneralMenu(InputOutputHandler inputOutputHandler, LibraryRepository repository) {
        menuOptionProviders = new LinkedHashMap<>();
        menuOptionProviders.put("1", new LoginMenuOption(inputOutputHandler));
        menuOptionProviders.put("2", new ListBooksMenuOption(repository));
        menuOptionProviders.put("3", new ListMoviesMenuOption(repository));
        menuOptionProviders.put("4", new QuitMenuOption());
    }

    @Override
    public ConsoleOutput getMenuOptions() {
        return super.getMenuOptionsFromMenuProviders(menuOptionProviders);
    }

    @Override
    public MenuOption getMenuForOption(String option) {
        return super.getMenuFromMenuProviders(menuOptionProviders, option);
    }
}
