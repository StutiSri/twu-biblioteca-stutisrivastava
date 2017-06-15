package com.twu.biblioteca;

import com.twu.model.menuoption.InvalidMenuOption;
import com.twu.model.menuoption.ListBooksMenuOption;
import com.twu.model.menuoption.MenuOption;
import com.twu.model.menuoption.QuitMenuOption;
import com.twu.io.output.ConsoleOutput;
import com.twu.io.output.Output;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MenuTest {
    @Test
    public void shouldReturnMenuOptions(){
        ArrayList<String> expectedMenuOptions = new ArrayList<>();
        expectedMenuOptions.add("Menu\n");
        expectedMenuOptions.add("\t1. List Books");
        expectedMenuOptions.add("\t2. Quit");
        expectedMenuOptions.add("\nPlease enter your choice : ");

        ConsoleOutput expectedOutput = new ConsoleOutput(expectedMenuOptions);

        Output output = new Menu().getMenuOptions();

        assertEquals(expectedOutput, output);
    }

    @Test
    public void
    shouldReturnListBooksMenuOptionFromMenuOptionInputChoiceForListBooks(){
        MenuOption menuOption = new Menu().getMenuForOption("1");

        assertTrue(menuOption instanceof ListBooksMenuOption);
    }

    @Test
    public void shouldReturnQuitMenuOptionFromMenuOptionInputChoiceForQuit(){
        MenuOption menuOption = new Menu().getMenuForOption("2");

        assertTrue(menuOption instanceof QuitMenuOption);
    }

    @Test
    public void
    shouldReturnInvalidMenuOptionFromMenuOptionInputChoiceWhichIsInvalid(){
        MenuOption menuOption = new Menu().getMenuForOption("0");

        assertTrue(menuOption instanceof InvalidMenuOption);
    }
}
