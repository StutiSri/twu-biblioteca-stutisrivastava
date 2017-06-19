package com.twu.model.user;

public class Librarian extends LibraryUser {
    public Librarian(String libraryNumber, String password) {
        super(libraryNumber, password, UserType.LIBRARIAN);
    }

    @Override
    public String toString() {
        return getLibraryNumber();
    }
}
