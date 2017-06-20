package com.twu.provider;

import com.twu.biblioteca.UserLogin;
import com.twu.exception.InvalidLoginException;
import com.twu.io.InputOutputHandler;
import com.twu.mockmodels.TestInputReader;
import com.twu.mockmodels.TestLibraryRepository;
import com.twu.mockmodels.TestOutputWriter;
import com.twu.mockmodels.TestUserLogin;
import com.twu.model.menu.CustomerMenu;
import com.twu.model.menu.GeneralMenu;
import com.twu.model.menu.LibrarianMenu;
import com.twu.model.menu.Menu;
import com.twu.model.menuprovider.MenuProvider;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class MenuProviderTest {
    @Test
    public void shouldReturnGeneralMenuWhenNoUserHasLoggedIn() {
        new TestUserLogin(null).reset();
        InputOutputHandler inputOutputHandler = new InputOutputHandler(new TestInputReader(""), new TestOutputWriter());
        MenuProvider menuProvider = new MenuProvider(inputOutputHandler, new TestLibraryRepository());

        Menu menu = menuProvider.getMenu();

        assertThat(menu, instanceOf(GeneralMenu.class));
    }

    @Test
    public void shouldReturnCustomerMenuWhenCustomerHasLoggedIn() throws InvalidLoginException {
        String libraryNumber = "STU-9176\n";
        String password = "password";
        TestInputReader inputReader = new TestInputReader(libraryNumber + password);
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(inputReader, new TestOutputWriter());
        UserLogin userLogin = new UserLogin(inputOutputHandler);
        userLogin.login();
        MenuProvider menuProvider = new MenuProvider(inputOutputHandler, new TestLibraryRepository());

        Menu menu = menuProvider.getMenu();

        assertThat(menu, instanceOf(CustomerMenu.class));
    }

    @Test
    public void shouldReturnLibrarianMenuWhenLibrarianHasLoggedIn() throws InvalidLoginException {
        String libraryNumber = "LIB-9176\n";
        String password = "password";
        TestInputReader inputReader = new TestInputReader(libraryNumber + password);
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(inputReader, new TestOutputWriter());
        UserLogin userLogin = new UserLogin(inputOutputHandler);
        userLogin.login();
        MenuProvider menuProvider = new MenuProvider(inputOutputHandler, new TestLibraryRepository());

        Menu menu = menuProvider.getMenu();

        assertThat(menu, instanceOf(LibrarianMenu.class));
    }
}
