package com.twu.model.menuoption;

import com.twu.model.artifacts.Artifact;
import com.twu.model.artifacts.Book;
import com.twu.io.output.ConsoleOutput;
import com.twu.model.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class ListBooksMenuOption implements MenuOption {

    private final Repository repository;

    public ListBooksMenuOption(Repository bookRepository) {

        this.repository = bookRepository;
    }

    @Override
    public ConsoleOutput action() {
        List<Artifact> allBooks = repository.getAvailableArtifacts();
        List<String> bookListing = new ArrayList<>();
        bookListing.add("\nAvailable Books :-\n");
        addColumnNames(bookListing);
        for(Artifact book : allBooks)
            bookListing.add(book.toString());
        bookListing.add("--------------------------------------------------\n");
        return new ConsoleOutput(bookListing);
    }

    private void addColumnNames(List<String> bookListing) {
        String column = String.format("%-30s%-29s%-14s", "Title","Author",
                "Year Published\n");
        bookListing.add(column);
    }
}
