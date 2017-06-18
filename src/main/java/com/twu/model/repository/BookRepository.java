package com.twu.model.repository;

import com.twu.biblioteca.Status;
import com.twu.model.artifacts.Artifact;
import com.twu.model.artifacts.Book;
import com.twu.model.artifacts.BookSorter;

import java.util.*;

import static com.twu.biblioteca.Status.AVAILABLE;
import static com.twu.biblioteca.Status.CHECKED_OUT;

public class BookRepository implements Repository {
    private Map<Book, Status> bookToBookStatusMap;

    public BookRepository(){
        bookToBookStatusMap = new HashMap<>();
        bookToBookStatusMap.put(new Book("Life of Pi", "Yann Martel", "2001"), AVAILABLE);
        bookToBookStatusMap.put(new Book("Fellowship of the Ring",
                "J. R. R. Tolkein","1991"), AVAILABLE);
        bookToBookStatusMap.put(new Book("Atlas Shrugged", "Ayn Rand", "1939"), AVAILABLE);
        bookToBookStatusMap.put(new Book("The Immortals of Meluha",
                "Amish Tripathi", "2010"), AVAILABLE);
        bookToBookStatusMap.put(new Book("Game of Thrones", "George R. R. Martin",
                "2001"), AVAILABLE);
        bookToBookStatusMap.put(new Book("To Kill a Mockingbird", "Harper Lee",
                "1960"), AVAILABLE);
    }

    @Override
    public List<Artifact> getAvailableArtifacts() {
        List<Artifact> availableBooks = new ArrayList<>();
        for(Map.Entry bookEntry : bookToBookStatusMap.entrySet()){
            if(bookEntry.getValue() == AVAILABLE)
                availableBooks.add((Book)bookEntry.getKey());
        }
        Collections.sort(availableBooks, new BookSorter());
        return availableBooks;
    }

    @Override
    public boolean checkoutArtifact(String title) {
        Book bookToBeCheckedOut = findBook(title);
        if( bookToBeCheckedOut == null) {
            return false;
        }
        bookToBookStatusMap.replace(bookToBeCheckedOut, CHECKED_OUT);
        return true;
    }

    private Book findBook(String titleOfBook) {
        for(Map.Entry bookEntry : bookToBookStatusMap.entrySet()) {
            Book book = (Book)bookEntry.getKey();
            if (book.getTitle().equalsIgnoreCase(titleOfBook)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public boolean returnArtifact(String title) {
        Book bookToBeReturned = findBook(title);
        if( bookToBeReturned == null)
            return false;

        if(bookToBookStatusMap.get(bookToBeReturned) == AVAILABLE)
            return false;

        bookToBookStatusMap.replace(bookToBeReturned, AVAILABLE);
        return true;
    }
}
