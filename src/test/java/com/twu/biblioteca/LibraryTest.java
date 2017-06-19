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

    private ConsoleOutput getUserMenuOptions() {
        List<String> expectedMenuOptions = new ArrayList<>();
        expectedMenuOptions.add("Menu\n");
        expectedMenuOptions.add("\t1. List Books");
        expectedMenuOptions.add("\t2. Checkout Book");
        expectedMenuOptions.add("\t3. Return Book");
        expectedMenuOptions.add("\t4. List Movies");
        expectedMenuOptions.add("\t5. Checkout Movie");
        expectedMenuOptions.add("\t6. My Account");
        expectedMenuOptions.add("\t7. Logout");
        expectedMenuOptions.add("\t8. Quit");
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
        String loginDetails = "STU-9176\npassword\n";
        String quitMenuOptionForUserMenu = "8\n";
        ConsoleOutput expectedMenuOptions = getUserMenuOptions();
        TestOutputWriter outputWriter = new TestOutputWriter();
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(new TestInputReader(loginMenuOption + loginDetails + quitMenuOptionForUserMenu),
                                         outputWriter);
        librarySystem = new LibrarySystem(inputOutputHandler);

        librarySystem.run();

        ConsoleOutput menuOptions = outputWriter.getMenuAfterLogin();
        assertEquals(expectedMenuOptions, menuOptions);
    }

    @Test
    public void shouldDisplayLoginSuccessfulAfterSuccessfulLoginByCustomer(){
        String loginMenuOption = "1\n";
        String loginDetails = "STU-9176\npassword\n";
        String quitMenuOptionForUserMenu = "8\n";
        ConsoleOutput expectedOutput = new ConsoleOutput("\nLogin successful.");
        TestOutputWriter outputWriter = new TestOutputWriter();
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(new TestInputReader(loginMenuOption + loginDetails + quitMenuOptionForUserMenu),
                        outputWriter);
        librarySystem = new LibrarySystem(inputOutputHandler);

        librarySystem.run();

        ConsoleOutput loginResult = outputWriter.getLoginResult();
        assertEquals(expectedOutput, loginResult);
    }

    @Test
    public void shouldDisplayLoginSuccessfulAfterSuccessfulLoginByLibrarian(){
        String loginMenuOption = "1\n";
        String loginDetails = "LIB-9176\npassword\n";
        String quitMenuOptionForUserMenu = "4\n";
        ConsoleOutput expectedOutput = new ConsoleOutput("\nLogin successful.");
        TestOutputWriter outputWriter = new TestOutputWriter();
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(new TestInputReader(loginMenuOption + loginDetails + quitMenuOptionForUserMenu),
                        outputWriter);
        librarySystem = new LibrarySystem(inputOutputHandler);

        librarySystem.run();

        ConsoleOutput loginResult = outputWriter.getLoginResult();
        assertEquals(expectedOutput, loginResult);
    }

    @Test
    public void librarianShouldSeeLibrarianMenuAfterLogin() {
        String loginMenuOption = "1\n";
        String loginDetails = "LIB-9176\npassword\n";
        String quitMenuOptionForLibrarianMenu = "4\n";
        ConsoleOutput expectedMenuOptions = getLibrarianMenuOptions();
        TestOutputWriter outputWriter = new TestOutputWriter();
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(new TestInputReader(loginMenuOption + loginDetails + quitMenuOptionForLibrarianMenu),
                        outputWriter);
        librarySystem = new LibrarySystem(inputOutputHandler);

        librarySystem.run();

        ConsoleOutput menuOptions = outputWriter.getMenuAfterLogin();
        assertEquals(expectedMenuOptions, menuOptions);
    }

    public ConsoleOutput getLibrarianMenuOptions() {
        List<String> expectedMenuOptions = new ArrayList<>();
        expectedMenuOptions.add("Menu\n");
        expectedMenuOptions.add("\t1. List checked out books");
        expectedMenuOptions.add("\t2. List checked out movies");
        expectedMenuOptions.add("\t3. Logout");
        expectedMenuOptions.add("\t4. Quit");
        expectedMenuOptions.add("\nPlease enter your choice :- ");
        return new ConsoleOutput(expectedMenuOptions);
    }

    @Test
    public void shouldDisplayGeneralMenuAfterCustomerLogout(){
        String loginMenuOption = "1\n";
        String loginDetails = "STU-9176\npassword\n";
        String logoutMenuOption = "7\n";
        String quitMenuOption = "4\n";
        ConsoleOutput expectedMenuOptions = getGeneralMenuOptions();
        TestOutputWriter outputWriter = new TestOutputWriter();
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(new TestInputReader(loginMenuOption + loginDetails +
                                                 logoutMenuOption + quitMenuOption), outputWriter);
        librarySystem = new LibrarySystem(inputOutputHandler);

        librarySystem.run();

        ConsoleOutput menuOptions = outputWriter.getMenuAfterLogout();
        assertEquals(expectedMenuOptions, menuOptions);
    }

    @Test
    public void shouldDisplayGeneralMenuAfterLibrarianLogout(){
        String loginMenuOption = "1\n";
        String loginDetails = "LIB-9176\npassword\n";
        String logoutMenuOption = "3\n";
        String quitMenuOption = "4\n";
        ConsoleOutput expectedMenuOptions = getGeneralMenuOptions();
        TestOutputWriter outputWriter = new TestOutputWriter();
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(new TestInputReader(loginMenuOption + loginDetails +
                        logoutMenuOption + quitMenuOption), outputWriter);
        librarySystem = new LibrarySystem(inputOutputHandler);

        librarySystem.run();

        ConsoleOutput menuOptions = outputWriter.getMenuAfterLogout();
        assertEquals(expectedMenuOptions, menuOptions);
    }

}
