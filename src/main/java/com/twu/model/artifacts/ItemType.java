package com.twu.model.artifacts;

public enum ItemType {
    MOVIE("Movies"), BOOK("Books");

    private final String name;

    ItemType(String name) {

        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
