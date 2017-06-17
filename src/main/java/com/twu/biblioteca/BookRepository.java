package com.twu.biblioteca;

import java.util.*;

import static com.twu.biblioteca.BookStatus.AVAILABLE;
import static com.twu.biblioteca.BookStatus.CHECKED_OUT;

public class BookRepository {
    private Map<Book, BookStatus> bookToBookStatusMap;

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

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for(Map.Entry bookEntry : bookToBookStatusMap.entrySet()){
            if(bookEntry.getValue() == AVAILABLE)
                availableBooks.add((Book)bookEntry.getKey());
        }
        Collections.sort(availableBooks);
        return availableBooks;
    }

    public boolean checkoutBook(String titleOfBook) {
        Book bookToBeCheckedOut = findBook(titleOfBook);
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

    public boolean returnBook(String titleOfBook) {
        Book bookToBeReturned = findBook(titleOfBook);
        if( bookToBeReturned == null)
            return false;

        if(bookToBookStatusMap.get(bookToBeReturned) == AVAILABLE)
            return false;

        bookToBookStatusMap.replace(bookToBeReturned, AVAILABLE);
        return true;
    }
}
