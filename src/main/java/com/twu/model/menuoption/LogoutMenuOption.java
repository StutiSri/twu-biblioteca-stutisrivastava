package com.twu.model.menuoption;

import com.twu.biblioteca.UserLogin;
import com.twu.exception.InvalidLogoutException;
import com.twu.io.output.ConsoleOutput;
import com.twu.model.user.Customer;
import org.omg.PortableInterceptor.SUCCESSFUL;

public class LogoutMenuOption implements MenuOption {

    private static final String SUCCESSFUL_LOGOUT_MESSAGE = "\nThank you for logging in. " +
            "Please log in again to continue.";
    private final String MENU_OPTION_NAME = "Logout";

    public LogoutMenuOption() {
    }

    @Override
    public ConsoleOutput action() {
        UserLogin userLogin = new UserLogin(null);
        try {
            userLogin.logout();
            return new ConsoleOutput(SUCCESSFUL_LOGOUT_MESSAGE);
        } catch (InvalidLogoutException e) {
            return new ConsoleOutput(e.getMessage());
        }
    }

    @Override
    public String getMenuOptionName() {
        return MENU_OPTION_NAME;
    }
}
