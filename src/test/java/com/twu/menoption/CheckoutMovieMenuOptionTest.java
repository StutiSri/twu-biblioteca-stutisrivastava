package com.twu.menoption;

import com.twu.io.InputOutputHandler;
import com.twu.io.output.ConsoleOutput;
import com.twu.mockmodels.TestInputReader;
import com.twu.mockmodels.TestLibraryRepository;
import com.twu.mockmodels.TestOutputWriter;
import com.twu.model.menuoption.CheckoutMovieMenuOption;
import com.twu.model.user.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckoutMovieMenuOptionTest {

    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("Stuti", "STU-9176", "stuti@gmail.com", "9176835429", "password");
    }


    @Test
    public void shouldCheckoutAvailableMovie() {
        String movieInput = "when harry met sally";
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(new TestInputReader(movieInput), new TestOutputWriter());
        CheckoutMovieMenuOption checkoutMovieMenuOption =
                new CheckoutMovieMenuOption(inputOutputHandler, new TestLibraryRepository(), customer);
        String successfulCheckoutMessage = "\nThank you! Enjoy the movie.\n";
        ConsoleOutput expectedOutput = new ConsoleOutput(successfulCheckoutMessage);

        ConsoleOutput output = checkoutMovieMenuOption.action();

        assertEquals(expectedOutput, output);
    }

    @Test
    public void shouldNotCheckoutUnavailableMovie() {
        String movieInput = "harry potter";
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(new TestInputReader(movieInput), new TestOutputWriter());
        CheckoutMovieMenuOption checkoutMovieMenuOption =
                new CheckoutMovieMenuOption(inputOutputHandler, new TestLibraryRepository(), customer);
        String unsuccessfulCheckoutMessage = "\nThat movie is not available.\n";
        ConsoleOutput expectedOutput = new ConsoleOutput(unsuccessfulCheckoutMessage);

        ConsoleOutput output = checkoutMovieMenuOption.action();

        assertEquals(expectedOutput, output);
    }
}
