package com.twu.model.user;

import com.twu.model.menu.Menu;
import com.twu.model.menu.UserMenu;

public class Customer{
    private final String name;
    private final String emailAddress;
    private final String phoneNumber;
    private final String libraryNumber;
    private final String password;

    public Customer(String name, String libraryNumber, String emailAddress,
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
        if(!(obj instanceof Customer))
            return false;
        Customer user = (Customer)obj;
        return user.libraryNumber.equals(libraryNumber);
    }

//    public Menu getMenu() {
//        return new UserMenu();
//    }
}
