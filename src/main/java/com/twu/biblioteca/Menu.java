package com.twu.biblioteca;

import com.twu.io.output.ConsoleOutput;
import com.twu.model.menuoption.InvalidMenuOption;
import com.twu.model.menuoption.MenuOption;
import com.twu.model.provider.ListBookMenuOptionOptionProvider;
import com.twu.model.provider.MenuOptionProvider;
import com.twu.model.provider.QuitMenuOptionOptionProvider;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<MenuOptionProvider> menuOptionProviders;

    public Menu(){
        menuOptionProviders = new ArrayList<>();
        menuOptionProviders.add(new ListBookMenuOptionOptionProvider());
        menuOptionProviders.add(new QuitMenuOptionOptionProvider());
    }

    public ConsoleOutput getMenuOptions(){
        ArrayList<String> menuOptions = new ArrayList<>();
        menuOptions.add("Menu\n");
        for(MenuOptionProvider menuOptionProvider : menuOptionProviders)
            menuOptions.add("\t" + menuOptionProvider.getMenuOption() + ". " +
                    menuOptionProvider.getMenu());
        menuOptions.add("\nPlease enter your choice : ");
        return new ConsoleOutput(menuOptions);
    }

    public MenuOption getMenuForOption(String option) {
        for(MenuOptionProvider menuOptionProvider : menuOptionProviders)
            if(menuOptionProvider.getMenuOption().equals(option))
                return menuOptionProvider.getMenu();
        return new InvalidMenuOption();
    }
}
