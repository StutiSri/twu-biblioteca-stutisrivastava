package com.twu.menu;

import com.twu.biblioteca.BookRepository;
import com.twu.io.output.ConsoleOutput;
import com.twu.model.menuoption.CheckoutMenuOption;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckoutMenuOptionTest {
    @Test
    public void shouldCheckoutAvailableBook(){
        String bookInput = "life of pi";
        CheckoutMenuOption checkoutMenuOption = new CheckoutMenuOption(bookInput);
        String successCheckoutMessage = "\nThank you! Enjoy the book.\n";
        ConsoleOutput expectedOutput = new ConsoleOutput(successCheckoutMessage);

        ConsoleOutput output = checkoutMenuOption.action(new BookRepository());

        assertEquals(expectedOutput, output);
    }

    @Test
    public void shouldNotCheckoutUnavailableBook(){
        String bookInput = "harry potter";
        CheckoutMenuOption checkoutMenuOption = new CheckoutMenuOption(bookInput);
        String unsuccessfulCheckoutMessage = "\nThat book is not available.\n";
        ConsoleOutput expectedOutput = new ConsoleOutput(unsuccessfulCheckoutMessage);

        ConsoleOutput output = checkoutMenuOption.action(new BookRepository());

        assertEquals(expectedOutput, output);
    }
}
