package com.twu.model.sorter;

import com.twu.model.artifacts.Artifact;
import com.twu.model.artifacts.Book;

import java.util.Comparator;

public class BookSorter implements Comparator<Artifact> {

    @Override
    public int compare(Artifact o1, Artifact o2) {
        Book bookOne = (Book)o1;
        Book bookTwo = (Book)o2;
        return bookOne.getTitle().compareTo(bookTwo.getTitle());
    }
}
