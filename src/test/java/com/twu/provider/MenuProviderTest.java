package com.twu.provider;

import com.twu.io.InputOutputHandler;
import com.twu.io.InputOutputHandlerTest;
import com.twu.mockmodels.*;
import com.twu.model.menu.GeneralMenu;
import com.twu.model.menu.Menu;
import com.twu.model.menuprovider.MenuProvider;
import com.twu.model.user.Customer;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class MenuProviderTest {
    @Test
    public void shouldReturnGeneralMenuWhenNoUserHasLoggedIn(){
        InputOutputHandler inputOutputHandler = new InputOutputHandler(new TestInputReader(""), new TestOutputWriter());

    }

    @Test
    public void shouldReturnUserMenuWhenCustomerHasLoggedIn(){
        Customer customer = new Customer("Stuti", "STU-9176", "stuti@gmail.com", "9176835429", "password");
        //Menu menu = customer.getMenu();

        //assertThat(menu, instanceOf(GeneralMenu.class));
    }
}
