package com.twu.model.artifacts;

public class Book implements Artifact {
    private String title;
    private final String author;
    private final String yearPublished;

    public Book(String title, String author, String yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Book))
            return false;
        Book book = (Book)obj;
        return title.equals(book.title) && author.equals(book.author) &&
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

    @Override
    public String toString() {
        return String.format("%-30s%-30s%-14s", title,
                author, yearPublished);
    }

}
