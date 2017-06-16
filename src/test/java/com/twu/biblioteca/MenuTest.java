package com.twu.biblioteca;

import com.twu.io.output.ConsoleOutput;
import com.twu.model.menuoption.InvalidMenuOption;
import com.twu.model.menuoption.ListBooksMenuOption;
import com.twu.model.menuoption.QuitMenuOption;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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
        String listBooksMenuOption = "1";
        assertThat(menu.getMenuForOption(listBooksMenuOption), instanceOf(ListBooksMenuOption.class));
    }

    @Test
    public void shouldReturnQuitMenuOptionFromMenuOptionInputChoiceForQuit(){
        String quitMenuOption = "2";
        assertThat(menu.getMenuForOption(quitMenuOption),
                instanceOf(QuitMenuOption.class));
    }

    @Test
    public void
    shouldReturnInvalidMenuOptionFromMenuOptionInputChoiceWhichIsInvalid(){
        String invalidMenuOption = "0";
        assertThat(menu.getMenuForOption("0"), instanceOf(InvalidMenuOption.class));
    }
}
