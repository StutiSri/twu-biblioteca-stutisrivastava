package com.twu.menu;

import com.twu.io.InputOutputHandler;
import com.twu.mockmodels.TestInputReader;
import com.twu.mockmodels.TestLibraryRepository;
import com.twu.mockmodels.TestOutputWriter;
import com.twu.model.menu.GeneralMenu;
import com.twu.model.menuoption.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class GeneralMenuTest {
    private GeneralMenu menu;

    @Before
    public void setUp(){
        menu = new GeneralMenu(new InputOutputHandler(new TestInputReader(""), new TestOutputWriter()),
                new TestLibraryRepository());
    }

    @Test
    public void shouldReturnLoginOptionFromMenuOptionInputChoiceForLogin(){
        String loginMenuOption = "1";
        assertThat(menu.getMenuForOption(loginMenuOption),
                instanceOf(LoginMenuOption.class));
    }

    @Test
    public void shouldReturnListBooksOptionFromMenuOptionInputChoiceForListBooks(){
        String listBooksMenuOption = "2";
        assertThat(menu.getMenuForOption(listBooksMenuOption),
                instanceOf(ListBooksMenuOption.class));
    }

    @Test
    public void shouldReturnListMoviesOptionFromMenuOptionInputChoiceForListMovies(){
        String listMoviesMenuOption = "3";
        assertThat(menu.getMenuForOption(listMoviesMenuOption),
                instanceOf(ListMoviesMenuOption.class));
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
        assertThat(menu.getMenuForOption(invalidMenuOption),
                instanceOf(InvalidMenuOption.class));
    }

}
