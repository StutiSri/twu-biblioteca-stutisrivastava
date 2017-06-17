package com.twu.menu;

import com.twu.biblioteca.Menu;
import com.twu.io.inputreader.InputReader;
import com.twu.io.outputwriter.ConsoleOutputWriter;
import com.twu.mockmodels.TestInputReader;
import com.twu.mockmodels.TestOutputWriter;
import com.twu.model.menuoption.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class MenuTest {

    private Menu menu;

    @Before
    public void setUp(){
        menu = new Menu(new TestInputReader(""), new TestOutputWriter());
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
    public void shouldReturnInvalidMenuOptionFromMenuOptionInputChoiceWhichIsInvalid(){
        String invalidMenuOption = "0";
        assertThat(menu.getMenuForOption(invalidMenuOption), instanceOf(InvalidMenuOption.class));
    }
}
