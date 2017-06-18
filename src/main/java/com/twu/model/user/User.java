package com.twu.model.user;

public class User {
    private final String name;
    private final String emailAddress;
    private final String phoneNumber;
    private final String libraryNumber;
    private final String password;

    public User(String name, String libraryNumber, String emailAddress,
                   String phoneNumber, String password) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof User))
            return false;
        User user = (User)obj;
        return user.libraryNumber.equals(libraryNumber);
    }
}
