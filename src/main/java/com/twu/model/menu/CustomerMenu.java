package com.twu.model.menu;

import com.twu.biblioteca.UserLogin;
import com.twu.io.InputOutputHandler;
import com.twu.io.output.ConsoleOutput;
import com.twu.model.menuoption.*;
import com.twu.model.repository.LibraryRepository;
import com.twu.model.user.Customer;

import java.util.LinkedHashMap;
import java.util.Map;

public class CustomerMenu extends Menu {

    private Map<String, MenuOption> menuOptionProviders;

    public CustomerMenu(InputOutputHandler inputOutputHandler, LibraryRepository repository) {
        Customer loggedInUser = (Customer) UserLogin.getLoggedInUser();
        menuOptionProviders = new LinkedHashMap<>();
        menuOptionProviders.put("1", new ListBooksMenuOption(repository));
        menuOptionProviders.put("2", new CheckoutBookMenuOption(inputOutputHandler, repository, loggedInUser));
        menuOptionProviders.put("3", new ReturnBookMenuOption(inputOutputHandler, repository));
        menuOptionProviders.put("4", new ListMoviesMenuOption(repository));
        menuOptionProviders.put("5", new CheckoutMovieMenuOption(inputOutputHandler, repository, loggedInUser));
        menuOptionProviders.put("6", new UserInformationMenuOption(loggedInUser));
        menuOptionProviders.put("7", new LogoutMenuOption());
        menuOptionProviders.put("8", new QuitMenuOption());
    }

    @Override
    public ConsoleOutput getMenuOptions() {
        return super.getMenuOptionsFromMenuProviders(menuOptionProviders);
    }

    @Override
    public MenuOption getMenuForOption(String option) {
        return super.getMenuFromMenuProviders(menuOptionProviders, option);
    }
}
