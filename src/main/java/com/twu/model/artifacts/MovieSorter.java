package com.twu.model.artifacts;

import java.util.Comparator;

public class MovieSorter implements Comparator<Artifact> {
    @Override
    public int compare(Artifact o1, Artifact o2) {
        Movie movieOne = (Movie)o1;
        Movie movieTwo = (Movie)o2;
        return movieOne.getTitle().compareTo(movieTwo.getTitle());
    }
}
