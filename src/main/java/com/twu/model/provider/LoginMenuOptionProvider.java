package com.twu.model.provider;

import com.twu.io.inputreader.InputReader;
import com.twu.io.outputwriter.OutputWriter;
import com.twu.model.menuoption.ListMoviesMenuOption;
import com.twu.model.menuoption.LoginMenuOption;
import com.twu.model.menuoption.MenuOption;

public class LoginMenuOptionProvider implements MenuOptionProvider {
    private final InputReader inputReader;
    private final OutputWriter outputWriter;

    private final String MENU_OPTION_NAME = "Login";
    private final String MENU_OPTION = "6";

    public LoginMenuOptionProvider(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }

    @Override
    public String getMenuOption() {
        return MENU_OPTION;
    }

    @Override
    public MenuOption getMenu() {
        return new LoginMenuOption(inputReader, outputWriter, null);
    }

    @Override
    public String getMenuOptionName() {
        return MENU_OPTION_NAME;
    }
}
