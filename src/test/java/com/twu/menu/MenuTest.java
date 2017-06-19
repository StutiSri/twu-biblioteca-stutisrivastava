package com.twu.menu;

import com.twu.biblioteca.Menu;
import com.twu.mockmodels.TestBookRepository;
import com.twu.mockmodels.TestInputReader;
import com.twu.mockmodels.TestMovieRepository;
import com.twu.mockmodels.TestOutputWriter;
import com.twu.model.menuoption.*;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class MenuTest {

    private Menu menu;

    @Before
    public void setUp(){
        menu = new Menu(new TestInputReader(""), new TestOutputWriter(),
                new TestBookRepository(), new TestMovieRepository());
    }

    @Test
    public void shouldReturnListBooksMenuOptionFromMenuOptionInputChoiceForListBooks(){
        String listBooksMenuOption = "1";
        assertThat(menu.getMenuForOption(listBooksMenuOption),
                               instanceOf(ListBooksMenuOption.class));
    }

    @Test
    public void shouldReturnCheckoutMenuOptionFromMenuOptionChoiceForCheckout(){
        String checkoutMenuOption = "2";
        assertThat(menu.getMenuForOption(checkoutMenuOption),
                            instanceOf(CheckoutBookMenuOption.class));
    }

    @Test
    public void shouldReturnReturnBookMenuOptionFromMenuOptionInputChoiceForReturnBook(){
        String returnBookMenuOption = "3";
        assertThat(menu.getMenuForOption(returnBookMenuOption),
                           instanceOf(ReturnBookMenuOption.class));
    }

    @Test
    public void shouldReturnListMoviesOptionFromMenuOptionInputChoiceForListMovies(){
        String listMoviesMenuOption = "4";
        assertThat(menu.getMenuForOption(listMoviesMenuOption),
                          instanceOf(ListMoviesMenuOption.class));
    }

    @Test
    public void shouldReturnLoginOptionFromMenuOptionInputChoiceForLogin(){
        String loginMenuOption = "6";
        assertThat(menu.getMenuForOption(loginMenuOption),
                           instanceOf(LoginMenuOption.class));
    }

    @Test
    public void shouldReturnQuitMenuOptionFromMenuOptionInputChoiceForQuit(){
        String quitMenuOption = "7";
        assertThat(menu.getMenuForOption(quitMenuOption),
                           instanceOf(QuitMenuOption.class));
    }

    @Test
    public void shouldReturnInvalidMenuOptionFromMenuOptionInputChoiceWhichIsInvalid(){
        String invalidMenuOption = "0";
        assertThat(menu.getMenuForOption(invalidMenuOption),
                           instanceOf(InvalidMenuOption.class));

        Map<Integer, String> x = new LinkedHashMap<>();
    }
}
