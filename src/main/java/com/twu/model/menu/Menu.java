package com.twu.model.menu;

import com.twu.io.output.ConsoleOutput;
import com.twu.model.menuoption.InvalidMenuOption;
import com.twu.model.menuoption.MenuOption;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Menu {
    abstract public ConsoleOutput getMenuOptions();

    abstract public MenuOption getMenuForOption(String option);

    public ConsoleOutput getMenuOptionsFromMenuProviders(Map<String, MenuOption> menuOptionProvider){
        List<String> menuOptions = new ArrayList<>();
        menuOptions.add("Menu\n");
        for(Map.Entry menuEntry : menuOptionProvider.entrySet()){
            MenuOption menuOption = (MenuOption) menuEntry.getValue();
            menuOptions.add("\t" + menuEntry.getKey() + ". " + menuOption.getMenuOptionName());
        }
        menuOptions.add("\nPlease enter your choice :- ");
        return new ConsoleOutput(menuOptions);
    }

    public MenuOption getMenuFromMenuProviders(Map<String, MenuOption> menuOptionProvider,
                                              String option){
        MenuOption menuOption = menuOptionProvider.get(option);
        if(menuOption == null)
            return new InvalidMenuOption();
        return menuOption;
    }
}
