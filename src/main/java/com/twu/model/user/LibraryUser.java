package com.twu.model.user;

public class LibraryUser {
    private String libraryNumber;
    private String password;
    private UserType userType;

    public LibraryUser(String libraryNumber, String password, UserType userType) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.userType = userType;
    }

    public boolean verifyCredentials(String inputLibraryNumber, String inputPassword) {
        return libraryNumber.equals(inputLibraryNumber)
                && password.equals(inputPassword);
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LibraryUser))
            return false;
        LibraryUser user = (LibraryUser) obj;
        return user.getLibraryNumber().equals(getLibraryNumber())
                && userType == user.userType;
    }

    public UserType getUserType() {
        return userType;
    }
}
