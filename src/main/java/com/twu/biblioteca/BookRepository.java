package com.twu.biblioteca;

import com.twu.model.menuoption.ListBooksMenuOption;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<Book> books;

    public BookRepository(){
        books = new ArrayList<>();
        books.add(new Book("Life of Pi", "Yann Martel", "2001"));
        books.add(new Book("Fellowship of the Ring",
                "J. R. R. Tolkein","1991"));
        books.add(new Book("Atlas Shrugged", "Ayn Rand", "1939"));
        books.add(new Book("The Immortals of Meluha",
                "Amish Tripathi", "2010"));
        books.add(new Book("Game of Thrones", "George R. R. Martin",
                "2001"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee",
                "1960"));
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for(Book book : books){
            if(book.isAvailable())
                availableBooks.add(book);
        }
        return availableBooks;
    }

    public boolean checkoutBook(String bookToBeCheckedOut) {
        for(Book book : books) {
            if (book.getTitle().equalsIgnoreCase(bookToBeCheckedOut)) {
                book.checkout();
                return true;
            }
        }
        return false;
    }
}
