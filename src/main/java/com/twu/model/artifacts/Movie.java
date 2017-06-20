package com.twu.model.artifacts;

public class Movie implements Artifact {
    private String title;
    private String yearOfRelease;
    private String director;
    private String rating;

    public Movie(String title, String yearOfRelease, String director, String rating) {

        this.title = title;
        this.yearOfRelease = yearOfRelease;
        this.director = director;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getRating() {
        return rating;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        String displayRating = rating;
        if (displayRating == null)
            displayRating = "Unrated";
        return String.format("%-30s%-17s%-30s%-7s",
                title, yearOfRelease, director, displayRating);
    }

    @Override
    public boolean equals(Object obj) {
        Movie movie = (Movie) obj;
        return movie.title.equalsIgnoreCase(title) &&
                movie.director.equalsIgnoreCase(director) &&
                movie.yearOfRelease.equals(yearOfRelease);
    }
}
