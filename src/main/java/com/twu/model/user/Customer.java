package com.twu.model.user;

import com.twu.io.output.ConsoleOutput;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> getDetails() {
        List<String> userData = new ArrayList<>();
        userData.add("Name : " + getName());
        userData.add("Email : " + getEmailAddress());
        userData.add("Phone Number : " + getPhoneNumber());
        return userData;
    }
}
