package com.twu.menu;

import com.twu.io.input.ConsoleInput;
import com.twu.io.output.ConsoleOutput;
import com.twu.mockmodels.TestBookRepository;
import com.twu.model.menuoption.CheckoutBookMenuOption;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckoutBookMenuOptionTest {
    @Test
    public void shouldCheckoutAvailableBook(){
        String bookInput = "atlas shrugged";
        CheckoutBookMenuOption checkoutBookMenuOption = new CheckoutBookMenuOption
                (new ConsoleInput(bookInput));
        String successfulCheckoutMessage = "\nThank you! Enjoy the book.\n";
        ConsoleOutput expectedOutput = new ConsoleOutput(successfulCheckoutMessage);

        ConsoleOutput output = checkoutBookMenuOption.action(new TestBookRepository());

        assertEquals(expectedOutput, output);
    }

    @Test
    public void shouldNotCheckoutUnavailableBook(){
        String bookInput = "harry potter";
        CheckoutBookMenuOption checkoutBookMenuOption = new CheckoutBookMenuOption
                (new ConsoleInput(bookInput));
        String unsuccessfulCheckoutMessage = "\nThat book is not available.\n";
        ConsoleOutput expectedOutput = new ConsoleOutput(unsuccessfulCheckoutMessage);

        ConsoleOutput output = checkoutBookMenuOption.action(new TestBookRepository());

        assertEquals(expectedOutput, output);
    }
}
