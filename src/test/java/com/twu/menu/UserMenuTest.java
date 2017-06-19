package com.twu.menu;

import com.twu.io.InputOutputHandler;
import com.twu.mockmodels.TestInputReader;
import com.twu.mockmodels.TestLibraryRepository;
import com.twu.mockmodels.TestOutputWriter;
import com.twu.model.menu.UserMenu;
import com.twu.model.menuoption.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class UserMenuTest {

    private UserMenu menu;

    @Before
    public void setUp() {
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(new TestInputReader(""), new TestOutputWriter());
        menu = new UserMenu(inputOutputHandler, new TestLibraryRepository());
    }

    @Test
    public void shouldReturnListBooksMenuOptionFromMenuOptionInputChoiceForListBooks() {
        String listBooksMenuOption = "1";
        assertThat(menu.getMenuForOption(listBooksMenuOption),
                instanceOf(ListBooksMenuOption.class));
    }

    @Test
    public void shouldReturnCheckoutBookMenuOptionFromMenuOptionChoiceForCheckoutBook() {
        String checkoutBookMenuOption = "2";
        assertThat(menu.getMenuForOption(checkoutBookMenuOption),
                instanceOf(CheckoutBookMenuOption.class));
    }

    @Test
    public void shouldReturnReturnBookMenuOptionFromMenuOptionInputChoiceForReturnBook() {
        String returnBookMenuOption = "3";
        assertThat(menu.getMenuForOption(returnBookMenuOption),
                instanceOf(ReturnBookMenuOption.class));
    }

    @Test
    public void shouldReturnListMoviesOptionFromMenuOptionInputChoiceForListMovies() {
        String listMoviesMenuOption = "4";
        assertThat(menu.getMenuForOption(listMoviesMenuOption),
                instanceOf(ListMoviesMenuOption.class));
    }


    @Test
    public void shouldReturnCheckoutMovieMenuOptionFromMenuOptionChoiceForCheckoutMovie() {
        String checkoutMovieMenuOption = "5";
        assertThat(menu.getMenuForOption(checkoutMovieMenuOption),
                instanceOf(CheckoutMovieMenuOption.class));
    }

    @Test
    public void shouldReturnUserInformationMenuOptionFromMenuOptionForUserInformation() {
        String userInformationMenuOption = "6";
        assertThat(menu.getMenuForOption(userInformationMenuOption),
                instanceOf(UserInformationMenuOption.class));
    }

    @Test
    public void shouldReturnLogOutMenuOptionFromMenuOptionForLogOut() {
        String logoutMenuOption = "7";
        assertThat(menu.getMenuForOption(logoutMenuOption),
                instanceOf(LogoutMenuOption.class));
    }

    @Test
    public void shouldReturnQuitMenuOptionFromMenuOptionInputChoiceForQuit() {
        String quitMenuOption = "8";
        assertThat(menu.getMenuForOption(quitMenuOption),
                instanceOf(QuitMenuOption.class));
    }

    @Test
    public void shouldReturnInvalidMenuOptionFromMenuOptionInputChoiceWhichIsInvalid() {
        String invalidMenuOption = "0";
        assertThat(menu.getMenuForOption(invalidMenuOption),
                instanceOf(InvalidMenuOption.class));
    }
}
