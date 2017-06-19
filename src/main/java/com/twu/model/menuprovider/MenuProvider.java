package com.twu.model.menuprovider;

import com.twu.io.InputOutputHandler;
import com.twu.model.menu.GeneralMenu;
import com.twu.model.menu.Menu;
import com.twu.model.menu.UserMenu;
import com.twu.model.repository.LibraryRepository;
import com.twu.model.user.Customer;

public class MenuProvider {
    private final InputOutputHandler inputOutputHandler;
    private final LibraryRepository libraryRepository;

    public MenuProvider(InputOutputHandler inputOutputHandler, LibraryRepository libraryRepository) {
        this.inputOutputHandler = inputOutputHandler;
        this.libraryRepository = libraryRepository;
    }

    public Menu getMenu(Customer loggedInUser) {
        if(loggedInUser == null)
            return new GeneralMenu(inputOutputHandler,libraryRepository, loggedInUser);
        return new UserMenu(inputOutputHandler, libraryRepository, loggedInUser);
    }
}
