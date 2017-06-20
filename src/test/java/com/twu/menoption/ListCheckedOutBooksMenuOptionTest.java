package com.twu.menoption;

import com.twu.io.output.ConsoleOutput;
import com.twu.mockmodels.TestLibraryRepository;
import com.twu.model.artifacts.Book;
import com.twu.model.menuoption.ListCheckedOutBooksMenuOption;
import com.twu.model.repository.LibraryRepository;
import com.twu.model.user.Customer;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ListCheckedOutBooksMenuOptionTest {

    @Test
    public void shouldListCheckedOutBooks() {
        Customer customer = new Customer("Test", "CUS-TEST", "test@gmail.com", "98", "test");
        TestLibraryRepository libraryRepository = new TestLibraryRepository();
        Book book = libraryRepository.checkoutBook("atlas shrugged", customer);
        ListCheckedOutBooksMenuOption listCheckedOutBooksMenuOption =
                new ListCheckedOutBooksMenuOption(libraryRepository);
        ConsoleOutput expectedOutput = getCheckedOutBooksDetails(book, customer);

        ConsoleOutput output = listCheckedOutBooksMenuOption.action();

        assertEquals(expectedOutput, output);
    }

    public ConsoleOutput getCheckedOutBooksDetails(Book book, Customer customer) {
        ArrayList<String> bookDetails = new ArrayList<>();
        bookDetails.add(String.format("%-20s %-20s %-20s","Title", "User Name", "Library Number"));
        bookDetails.add(String.format("%-20s %-20s %-20s",book.getTitle(), customer.getName(), customer.getLibraryNumber()));
        return new ConsoleOutput(bookDetails);
    }

    @Test
    public void shouldReturnNoCheckedOutBooksMessageWhenThereAreNoCheckedOutBooks() {
        TestLibraryRepository libraryRepository = new TestLibraryRepository();
        ListCheckedOutBooksMenuOption listCheckedOutBooksMenuOption =
                new ListCheckedOutBooksMenuOption(libraryRepository);
        ConsoleOutput expectedOutput = new ConsoleOutput("\nThere are no checked out books.");

        ConsoleOutput output = listCheckedOutBooksMenuOption.action();

        assertEquals(expectedOutput, output);
    }
}
