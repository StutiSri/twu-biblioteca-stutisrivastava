package com.twu.menu;

import com.twu.io.input.ConsoleInput;
import com.twu.mockmodels.TestInputReader;
import com.twu.model.menuoption.CheckoutMenuOption;
import com.twu.model.menuoption.MenuOption;
import com.twu.model.provider.CheckoutMenuOptionProvider;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckoutMenuOptionProviderTest {

    @Test
    public void shouldCreateCheckoutMenuOptionForBookInput(){
        String bookInput = "life of pi";
        TestInputReader testInputReader = new TestInputReader(bookInput);
        CheckoutMenuOptionProvider checkoutMenuOptionProvider =
                new CheckoutMenuOptionProvider(testInputReader);
        CheckoutMenuOption expectedCheckoutMenuOption = new CheckoutMenuOption(bookInput);

        MenuOption checkoutMenuOption = checkoutMenuOptionProvider.getMenu();

        assertEquals(expectedCheckoutMenuOption, checkoutMenuOption);
    }
}
