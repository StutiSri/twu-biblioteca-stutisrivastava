package com.twu.biblioteca;

import com.twu.model.provider.ListBookMenuOptionOptionProvider;
import com.twu.model.provider.MenuOptionProvider;
import com.twu.model.provider.QuitMenuOptionOptionProvider;
import com.twu.output.ConsoleOutput;
import com.twu.output.Output;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<MenuOptionProvider> menuOptionProviders;

    public Menu(){
        menuOptionProviders = new ArrayList<>();
        menuOptionProviders.add(new ListBookMenuOptionOptionProvider());
        menuOptionProviders.add(new QuitMenuOptionOptionProvider());
    }

    public Output getMenuOptions(){
        String menuOptions = "Menu\n";
        for(MenuOptionProvider menuOptionProvider : menuOptionProviders)
            menuOptions += "\n\t" + menuOptionProvider.getMenuOption() + ". " +
                    menuOptionProvider.getMenu();
        menuOptions += "\n\nPlease enter your choice : ";
        return new ConsoleOutput(menuOptions);
    }
}
