package com.twu.biblioteca;

public class Book {
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

    public void checkout() {
        isAvailable = false;
    }

    public void makeAvailable() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return String.format("%-30s%-30s%-14s", getTitle(),
                getAuthor(), getYearPublished());
    }
}
