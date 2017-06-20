package com.twu.menoption;

import com.twu.io.output.ConsoleOutput;
import com.twu.model.menuoption.InvalidMenuOption;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InvalidMenuOptionTest {

    @Test
    public void shouldReturnInvalidMenuOptionMessage() {
        ConsoleOutput expectedInvalidOptionMessage = new ConsoleOutput("Select a valid option!\n");
        ConsoleOutput invalidMenuOptionMessage = new InvalidMenuOption().action();
        assertEquals(expectedInvalidOptionMessage, invalidMenuOptionMessage);
    }
}
