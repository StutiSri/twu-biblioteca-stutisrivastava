package com.twu.model.menu;

import com.twu.io.InputOutputHandler;
import com.twu.io.output.ConsoleOutput;
import com.twu.model.menuoption.*;
import com.twu.model.repository.LibraryRepository;

import java.util.LinkedHashMap;
import java.util.Map;

public class LibrarianMenu extends Menu {
    private final Map<String, MenuOption> menuOptionProviders;

    public LibrarianMenu(LibraryRepository repository) {
        menuOptionProviders = new LinkedHashMap<>();
        menuOptionProviders.put("1", new ListCheckedOutBooksMenuOption(repository));
        menuOptionProviders.put("5", new QuitMenuOption());
    }

    @Override
    public ConsoleOutput getMenuOptions() {
        return null;
    }

    @Override
    public MenuOption getMenuForOption(String option) {
        return null;
    }
}
