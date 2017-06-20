package com.twu.menu;

import com.twu.mockmodels.TestLibraryRepository;
import com.twu.model.menu.LibrarianMenu;
import com.twu.model.menuoption.ListCheckedOutBooksMenuOption;
import com.twu.model.menuoption.ListCheckedOutMoviesMenuOption;
import com.twu.model.menuoption.LogoutMenuOption;
import com.twu.model.menuoption.QuitMenuOption;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class LibrarianMenuTest {
    private LibrarianMenu menu;

    @Before
    public void setUp() {
        menu = new LibrarianMenu(new TestLibraryRepository());
    }

    @Test
    public void shouldReturnListCheckedOutBooksFromMenuOptionInputChoiceForListingCheckedOutBooks() {
        String listCheckedOutBookMenuOption = "1";
        assertThat(menu.getMenuForOption(listCheckedOutBookMenuOption),
                instanceOf(ListCheckedOutBooksMenuOption.class));
    }

    @Test
    public void shouldReturnListCheckedOutMoviesFromMenuOptionInputChoiceForListingCheckedOutMovies() {
        String listMoviesMenuOption = "2";
        assertThat(menu.getMenuForOption(listMoviesMenuOption),
                instanceOf(ListCheckedOutMoviesMenuOption.class));
    }

    @Test
    public void shouldReturnLogOutMenuOptionFromMenuOptionForLogOut() {
        String logoutMenuOption = "3";
        assertThat(menu.getMenuForOption(logoutMenuOption),
                instanceOf(LogoutMenuOption.class));
    }

    @Test
    public void shouldReturnQuitMenuOptionFromMenuOptionInputChoiceForQuit() {
        String quitMenuOption = "4";
        assertThat(menu.getMenuForOption(quitMenuOption),
                instanceOf(QuitMenuOption.class));
    }
}
