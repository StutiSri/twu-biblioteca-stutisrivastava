package com.twu.biblioteca;

public class Book implements Comparable<Book> {
    private String title;
    private final String author;
    private final String yearPublished;
    private boolean isAvailable;

    public Book(String title, String author, String yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        isAvailable = true;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Book))
            return false;
        Book book = (Book)obj;
        return title.equals(book.getTitle()) && author.equals(book.author) &&
                yearPublished.equals(book.yearPublished);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean checkoutBook() {
        isAvailable = false;
        return true;
    }

    public void makeAvailable() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return String.format("%-30s%-30s%-14s", getTitle(),
                getAuthor(), getYearPublished());
    }

    public boolean returnBook() {
        isAvailable = true;
        return true;
    }

    @Override
    public int compareTo(Book book) {
        return book.getTitle().compareTo(title);
    }
}
