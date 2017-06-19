package com.twu.model.user;

public class Customer extends LibraryUser {
    private String name;
    private String emailAddress;
    private String phoneNumber;

    public Customer(String name, String libraryNumber, String emailAddress,
                    String phoneNumber, String password) {
        super(libraryNumber, password, UserType.CUSTOMER);
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return name;
    }
}
