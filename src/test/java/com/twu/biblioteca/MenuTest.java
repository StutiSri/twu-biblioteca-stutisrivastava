package com.twu.biblioteca;

import com.twu.model.menuoption.InvalidMenuOption;
import com.twu.model.menuoption.ListBooksMenuOption;
import com.twu.model.menuoption.MenuOption;
import com.twu.model.menuoption.QuitMenuOption;
import com.twu.io.output.ConsoleOutput;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MenuTest {

    private Menu menu;

    @Before
    public void setUp(){
        menu = new Menu();
    }

    @Test
    public void shouldReturnMenuOptions(){
        ArrayList<String> expectedMenuOptions = getMenuOptions();
        ConsoleOutput expectedOutput = new ConsoleOutput(expectedMenuOptions);

        ConsoleOutput output = menu.getMenuOptions();

        assertEquals(expectedOutput, output);
    }

    private ArrayList<String> getMenuOptions() {
        ArrayList<String> expectedMenuOptions = new ArrayList<>();
        expectedMenuOptions.add("Menu\n");
        expectedMenuOptions.add("\t1. List Books");
        expectedMenuOptions.add("\t2. Quit");
        expectedMenuOptions.add("\nPlease enter your choice : ");
        return expectedMenuOptions;
    }

    @Test
    public void
    shouldReturnListBooksMenuOptionFromMenuOptionInputChoiceForListBooks(){
        MenuOption listBooksMenuOption = menu.getMenuForOption("1");
        assertTrue(listBooksMenuOption instanceof ListBooksMenuOption);
    }

    @Test
    public void shouldReturnQuitMenuOptionFromMenuOptionInputChoiceForQuit(){
        MenuOption quitMenuOption = menu.getMenuForOption("2");
        assertTrue(quitMenuOption instanceof QuitMenuOption);
    }

    @Test
    public void
    shouldReturnInvalidMenuOptionFromMenuOptionInputChoiceWhichIsInvalid(){
        MenuOption invalidMenuOption = menu.getMenuForOption("0");
        assertTrue(invalidMenuOption instanceof InvalidMenuOption);
    }
}
