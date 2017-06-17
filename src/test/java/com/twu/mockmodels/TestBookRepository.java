package com.twu.mockmodels;

import com.twu.biblioteca.Book;

import java.util.ArrayList;
import java.util.List;

public class TestBookRepository {

    private final List<Book> books;
    private Book checkedOutBook;

    public TestBookRepository(){
        books = new ArrayList<>();
        books.add(new Book("Life of Pi", "Yann Martel", "2001"));
        books.add(new Book("Fellowship of the Ring",
                "J. R. R. Tolkein","1991"));

        checkedOutBook = new Book("Atlas Shrugged", "Ayn Rand", "1939");
        books.add(checkedOutBook);

        books.add(new Book("The Immortals of Meluha",
                "Amish Tripathi", "2010"));
        books.add(new Book("Game of Thrones", "George R. R. Martin",
                "2001"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee",
                "1960"));
    }

    public List<Book> getBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for(Book book : books)
            if(book.isAvailable())
                availableBooks.add(book);
        return availableBooks;
    }

    public List<String> getBookListing(){
        List<String> bookListing = new ArrayList<>();

        bookListing.add("\nAvailable Books :-\n");
        addColumnNames(bookListing);

        for(Book book : books) {
                addBookInColumnRepresentation(bookListing, book);
        }

        bookListing.add("--------------------------------------------------\n");

        return bookListing;
    }

    private void addColumnNames(List<String> bookListing) {
        String columns = String.format("%-30s%-28s%-14s\n",
                "Title", "Author", " Year Published");
        bookListing.add(columns);
    }

    private void addBookInColumnRepresentation(List<String> bookListRepresentation, Book book) {
        String bookRepresentation = String.format("%-30s%-30s%-14s",
                book.getTitle(), book.getAuthor(), book.getYearPublished());
        bookListRepresentation.add(bookRepresentation);
    }

    public void checkoutBook(){
        checkedOutBook.checkout();
    }
}
