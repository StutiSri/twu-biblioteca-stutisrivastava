package com.twu.model.menuoption;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.BookRepository;
import com.twu.io.output.ConsoleOutput;

import java.util.ArrayList;
import java.util.List;

public class ListBooksMenuOption implements MenuOption {

    public static final String MENU_OPTION = "List Books";

    @Override
    public String toString() {
        return MENU_OPTION;
    }

    @Override
    public ConsoleOutput action(BookRepository bookRepository) {
        List<Book> allBooks = bookRepository.getAllBooks();
        List<String> booksAsStrings = new ArrayList<>();
        booksAsStrings.add("\nAvailable Books :-\n");
        for(Book book : allBooks)
            booksAsStrings.add(book.toString());
        return new ConsoleOutput(booksAsStrings);
    }
}
