package com.twu.biblioteca;

import com.twu.io.inputreader.InputReader;
import com.twu.io.output.ConsoleOutput;
import com.twu.io.outputwriter.OutputWriter;
import com.twu.model.menuoption.InvalidMenuOption;
import com.twu.model.menuoption.MenuOption;
import com.twu.model.provider.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<MenuOptionProvider> menuOptionProviders;

    public Menu(InputReader inputReader, OutputWriter outputWriter){
        menuOptionProviders = new ArrayList<>();
        menuOptionProviders.add(new ListBookMenuOptionProvider());
        menuOptionProviders.add(new CheckoutBookMenuOptionProvider(inputReader, outputWriter));
        menuOptionProviders.add(new ReturnBookMenuOptionProvider(inputReader, outputWriter));
        menuOptionProviders.add(new QuitMenuOptionProvider());
    }

    public ConsoleOutput getMenuOptions(){
        List<String> menuOptions = new ArrayList<>();
        menuOptions.add("Menu\n");
        for(MenuOptionProvider menuOptionProvider : menuOptionProviders)
            menuOptions.add("\t" + menuOptionProvider.getMenuOption() + ". " +
                    menuOptionProvider.getMenuOptionName());
        menuOptions.add("\nPlease enter your choice :- ");
        return new ConsoleOutput(menuOptions);
    }

    public MenuOption getMenuForOption(String option) {
        for(MenuOptionProvider menuOptionProvider : menuOptionProviders) {
            if (menuOptionProvider.getMenuOption().equals(option))
                return menuOptionProvider.getMenu();
        }
        return new InvalidMenuOption();
    }
}
