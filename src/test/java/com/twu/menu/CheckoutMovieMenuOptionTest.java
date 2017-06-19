package com.twu.menu;

import com.twu.io.input.ConsoleInput;
import com.twu.io.output.ConsoleOutput;
import com.twu.mockmodels.TestMovieRepository;
import com.twu.mockmodels.TestMovieRepository;
import com.twu.model.menuoption.CheckoutMovieMenuOption;
import com.twu.model.menuoption.CheckoutMovieMenuOption;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckoutMovieMenuOptionTest {
    @Test
    public void shouldCheckoutAvailableMovie(){
        String movieInput = "when harry met sally";
        CheckoutMovieMenuOption checkoutMovieMenuOption = new CheckoutMovieMenuOption
                (new TestMovieRepository(), new ConsoleInput(movieInput));
        String successfulCheckoutMessage = "\nThank you! Enjoy the movie.\n";
        ConsoleOutput expectedOutput = new ConsoleOutput(successfulCheckoutMessage);

        ConsoleOutput output = checkoutMovieMenuOption.action();

        assertEquals(expectedOutput, output);
    }
    
    @Test
    public void shouldNotCheckoutUnavailableMovie(){
        String movieInput = "harry potter";
        CheckoutMovieMenuOption checkoutMovieMenuOption = new CheckoutMovieMenuOption
                (new TestMovieRepository(), new ConsoleInput(movieInput));
        String unsuccessfulCheckoutMessage = "\nThat movie is not available.\n";
        ConsoleOutput expectedOutput = new ConsoleOutput(unsuccessfulCheckoutMessage);

        ConsoleOutput output = checkoutMovieMenuOption.action();

        assertEquals(expectedOutput, output);
    }
}
