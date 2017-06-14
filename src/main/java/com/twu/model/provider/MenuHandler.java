package com.twu.model.provider;

import com.twu.output.ConsoleOutput;
import com.twu.output.Output;

import java.util.ArrayList;
import java.util.List;

public class MenuHandler {

    private List<MenuProvider> menuProviders;

    public MenuHandler(){
        menuProviders = new ArrayList<>();
    }

    public Output getMenuOptions(){
        String outputMessage = "Menu";
        for(MenuProvider menuProvider : menuProviders)
            outputMessage += "\n\t" + menuProvider.getMenuOption() +
                    menuProvider.getMenu();
        return new ConsoleOutput(outputMessage);
    }
}
