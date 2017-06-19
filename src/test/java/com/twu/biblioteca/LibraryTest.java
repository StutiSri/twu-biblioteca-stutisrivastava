package com.twu.biblioteca;


import com.twu.io.InputOutputHandler;
import com.twu.io.output.ConsoleOutput;
import com.twu.mockmodels.TestLibraryRepository;
import com.twu.mockmodels.TestInputReader;
import com.twu.mockmodels.TestOutputWriter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private LibrarySystem librarySystem;
    private String quitMenuOption;
    private ConsoleOutput generalMenuOptions;

    @Before
    public void setUp() {
        quitMenuOption = "8\n";
    }

    private ConsoleOutput getExpectedWelcomeMessage() {
        List<String> expectedWelcomeMessage = new ArrayList<>();
        expectedWelcomeMessage.add("Hello Customer! Welcome to Biblioteca! :)\n");
        return new ConsoleOutput(expectedWelcomeMessage);
    }

    @Test
    public void userShouldBeGreetedWithWelcomeMessageOnApplicationStartup() {
        String quitMenuOption = "4\n";
        ConsoleOutput expectedWelcomeMessage = getExpectedWelcomeMessage();
        TestOutputWriter outputWriter = new TestOutputWriter();
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(new TestInputReader(quitMenuOption), outputWriter);
        librarySystem = new LibrarySystem(inputOutputHandler);

        librarySystem.run();

        ConsoleOutput welcomeMessage = outputWriter.getOutputForWelcomeMessage();
        assertEquals(expectedWelcomeMessage, welcomeMessage);
    }

    @Test
    public void userShouldGetGeneralMenuAfterWelcomeMessage() {
        String quitMenuOption = "4\n";
        ConsoleOutput expectedMenuOptions = getGeneralMenuOptions();
        TestOutputWriter outputWriter = new TestOutputWriter();
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(new TestInputReader(quitMenuOption), outputWriter);
        librarySystem = new LibrarySystem(inputOutputHandler);

        librarySystem.run();

        ConsoleOutput menuOptions = outputWriter.getOutputForMenuAfterWelcomeMessage();
        assertEquals(expectedMenuOptions, menuOptions);
    }

    private ConsoleOutput getExpectedMenuOptions() {
        List<String> expectedMenuOptions = new ArrayList<>();
        expectedMenuOptions.add("Menu\n");
        expectedMenuOptions.add("\t1. List Books");
        expectedMenuOptions.add("\t2. Checkout Book");
        expectedMenuOptions.add("\t3. Return Book");
        expectedMenuOptions.add("\t4. List Movies");
        expectedMenuOptions.add("\t5. Checkout Movie");
        expectedMenuOptions.add("\t6. Login");
        expectedMenuOptions.add("\t7. Quit");
        expectedMenuOptions.add("\nPlease enter your choice :- ");
        return new ConsoleOutput(expectedMenuOptions);
    }

    @Test
    public void shouldExitFromMenuWhenUserSelectsQuitOption() {
        String quitMenuOption = "4\n";
        TestOutputWriter outputWriter = new TestOutputWriter();
        String quitMenuOptionMessage = "Thank you for using Biblioteca.";
        ConsoleOutput expectedQuitMenuOptionMessage = new ConsoleOutput(quitMenuOptionMessage);
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(new TestInputReader(quitMenuOption), outputWriter);
        librarySystem = new LibrarySystem(inputOutputHandler);

        librarySystem.run();

        List<ConsoleOutput> outputMessages = outputWriter.getOutputMessagesAfterUsersChoosesAMenuOption();
        ConsoleOutput actualQuitMenuOptionMessage = outputMessages.get(0);
        assertEquals(expectedQuitMenuOptionMessage, actualQuitMenuOptionMessage);
    }

    @Test
    public void shouldKeepOnDisplayingMenuUntilUserChoosesToQuit() {
        String bookListingMenuOptionInput = "2\n";
        String quitMenuOptionInput = "4\n";
        TestOutputWriter outputWriter = new TestOutputWriter();
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(new TestInputReader(bookListingMenuOptionInput + quitMenuOptionInput), outputWriter);
        librarySystem = new LibrarySystem(inputOutputHandler);
        ConsoleOutput outputForListBooksMenuOption = new ConsoleOutput
                (new TestLibraryRepository().getBookListing());
        ConsoleOutput menuOptionsOutput = getGeneralMenuOptions();
        String quitMenuOptionMessage = "Thank you for using Biblioteca.";
        ConsoleOutput expectedQuitMenuOptionMessage = new ConsoleOutput(quitMenuOptionMessage);

        librarySystem.run();

        List<ConsoleOutput> outputMessages = outputWriter.getOutputMessagesAfterUsersChoosesAMenuOption();
        ConsoleOutput bookListingOutput = outputMessages.get(0);
        assertEquals(outputForListBooksMenuOption, bookListingOutput);

        ConsoleOutput menuOptions = outputMessages.get(1);
        assertEquals(menuOptionsOutput, menuOptions);

        ConsoleOutput actualQuitMenuOptionMessage = outputMessages.get(2);
        assertEquals(expectedQuitMenuOptionMessage, actualQuitMenuOptionMessage);
    }

    /*@Test
    public void menuOptionsShouldChangeAfterSuccesfulLogin(){
        String loginMenuOptionInput = "6\n";
        String loginDetails = "STU-9176\npassword\n";
        String quitMenuOptionInput = "7\n";
        TestOutputWriter outputWriter = new TestOutputWriter();
        librarySystem = new LibrarySystem(new TestInputReader
                (loginMenuOptionInput + loginDetails + quitMenuOptionInput), outputWriter);
        String successfulMessage = "\nLogin successful.";
        ConsoleOutput outputAfterSuccessfulLogin = new ConsoleOutput(successfulMessage);
        ConsoleOutput menuOptionsOutput = getExpectedMenuOptionsAfterSuccesfulLogin();

        librarySystem.run();

        ConsoleOutput bookListingOutput = outputWriter.getLoginResult();
        assertEquals(outputAfterSuccessfulLogin, bookListingOutput);

        ConsoleOutput menuOptions = outputWriter.getMenuAfterLogin();
        assertEquals(menuOptionsOutput, menuOptions);
    }*/

    private ConsoleOutput getUserMenuOptions() {
        List<String> expectedMenuOptions = new ArrayList<>();
        expectedMenuOptions.add("Menu\n");
        expectedMenuOptions.add("\t1. List Books");
        expectedMenuOptions.add("\t2. Checkout Book");
        expectedMenuOptions.add("\t3. Return Book");
        expectedMenuOptions.add("\t4. List Movies");
        expectedMenuOptions.add("\t6. Customer Information");
        expectedMenuOptions.add("\t7. Quit");
        expectedMenuOptions.add("\nPlease enter your choice :- ");
        return new ConsoleOutput(expectedMenuOptions);
    }

    public ConsoleOutput getGeneralMenuOptions() {
        List<String> expectedMenuOptions = new ArrayList<>();
        expectedMenuOptions.add("Menu\n");
        expectedMenuOptions.add("\t1. Login to checkout and return");
        expectedMenuOptions.add("\t2. List Books");
        expectedMenuOptions.add("\t3. List Movies");
        expectedMenuOptions.add("\t4. Quit");
        expectedMenuOptions.add("\nPlease enter your choice :- ");
        return new ConsoleOutput(expectedMenuOptions);
    }

    @Test
    public void customerShouldSeeCustomerMenuAfterLogin() {
        String loginMenuOption = "1\n";
        String quitMenuOptionForUserMenu = "4\n";
        ConsoleOutput expectedMenuOptions = getUserMenuOptions();
        TestOutputWriter outputWriter = new TestOutputWriter();
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(new TestInputReader(loginMenuOption + quitMenuOptionForUserMenu),
                                                             outputWriter);
        librarySystem = new LibrarySystem(inputOutputHandler);

        librarySystem.run();

        ConsoleOutput menuOptions = outputWriter.getMenuAfterLogin();
        assertEquals(expectedMenuOptions, menuOptions);
    }
}
