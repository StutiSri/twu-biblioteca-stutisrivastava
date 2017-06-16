package com.twu.biblioteca;

import com.sun.tools.javac.comp.Check;
import com.twu.io.output.ConsoleOutput;
import com.twu.model.menuoption.*;
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
    public void
    shouldReturnListBooksMenuOptionFromMenuOptionInputChoiceForListBooks(){
        String listBooksMenuOption = "1";
        assertThat(menu.getMenuForOption(listBooksMenuOption), instanceOf(ListBooksMenuOption.class));
    }

    @Test
    public void shouldReturnCheckoutMenuOptionFromMenuOptionChoiceForCheckout(){
        String checkoutMenuOption = "2";
        assertThat(menu.getMenuForOption(checkoutMenuOption), instanceOf(CheckoutMenuOption.class));
    }

    @Test
    public void shouldReturnReturnBookMenuOptionFromMenuOptionInputChoiceForReturnBook(){
        String returnBookMenuOption = "3";
        assertThat(menu.getMenuForOption(returnBookMenuOption), instanceOf(ReturnBookMenuOption.class));
    }

    @Test
    public void shouldReturnQuitMenuOptionFromMenuOptionInputChoiceForQuit(){
        String quitMenuOption = "4";
        assertThat(menu.getMenuForOption(quitMenuOption),
                instanceOf(QuitMenuOption.class));
    }

    @Test
    public void
    shouldReturnInvalidMenuOptionFromMenuOptionInputChoiceWhichIsInvalid(){
        String invalidMenuOption = "0";
        assertThat(menu.getMenuForOption(invalidMenuOption), instanceOf(InvalidMenuOption.class));
    }
}
