package com.twu.model.menuprovider;

import com.twu.biblioteca.UserLogin;
import com.twu.io.InputOutputHandler;
import com.twu.model.menu.CustomerMenu;
import com.twu.model.menu.GeneralMenu;
import com.twu.model.menu.LibrarianMenu;
import com.twu.model.menu.Menu;
import com.twu.model.repository.LibraryRepository;
import com.twu.model.user.LibraryUser;

import static com.twu.model.user.UserType.CUSTOMER;

public class MenuProvider {
    private final InputOutputHandler inputOutputHandler;
    private final LibraryRepository libraryRepository;

    public MenuProvider(InputOutputHandler inputOutputHandler, LibraryRepository libraryRepository) {
        this.inputOutputHandler = inputOutputHandler;
        this.libraryRepository = libraryRepository;
    }

    public Menu getMenu() {
        LibraryUser loggedInUser = UserLogin.getLoggedInUser();
        if (loggedInUser == null)
            return new GeneralMenu(inputOutputHandler, libraryRepository);
        if (loggedInUser.getUserType() == CUSTOMER)
            return new CustomerMenu(inputOutputHandler, libraryRepository);
        return new LibrarianMenu(libraryRepository);
    }
}
