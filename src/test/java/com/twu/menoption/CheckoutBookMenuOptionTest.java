package com.twu.menoption;

import com.twu.io.InputOutputHandler;
import com.twu.io.output.ConsoleOutput;
import com.twu.mockmodels.TestInputReader;
import com.twu.mockmodels.TestLibraryRepository;
import com.twu.mockmodels.TestOutputWriter;
import com.twu.model.menuoption.CheckoutBookMenuOption;
import com.twu.model.user.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckoutBookMenuOptionTest {
    private Customer customer;

    @Before
    public void setUp(){
        customer = new Customer("Stuti", "STU-9176", "stuti@gmail.com", "9176835429", "password");
    }

    @Test
    public void shouldCheckoutAvailableBook(){
        String bookInput = "atlas shrugged";
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(new TestInputReader(bookInput), new TestOutputWriter());
        CheckoutBookMenuOption checkoutBookMenuOption =
                new CheckoutBookMenuOption(inputOutputHandler, new TestLibraryRepository(), customer);
        String successfulCheckoutMessage = "\nThank you! Enjoy the book.\n";
        ConsoleOutput expectedOutput = new ConsoleOutput(successfulCheckoutMessage);

        ConsoleOutput output = checkoutBookMenuOption.action();

        assertEquals(expectedOutput, output);
    }

    @Test
    public void shouldNotCheckoutUnavailableBook(){
        String bookInput = "harry potter";
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(new TestInputReader(bookInput), new TestOutputWriter());
        CheckoutBookMenuOption checkoutBookMenuOption =
                new CheckoutBookMenuOption(inputOutputHandler, new TestLibraryRepository(), customer);
        String unsuccessfulCheckoutMessage = "\nThat book is not available.\n";
        ConsoleOutput expectedOutput = new ConsoleOutput(unsuccessfulCheckoutMessage);

        ConsoleOutput output = checkoutBookMenuOption.action();

        assertEquals(expectedOutput, output);
    }
}
