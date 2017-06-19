package com.twu.model.menuoption;

import com.twu.io.output.ConsoleOutput;
import com.twu.model.repository.Repository;

public interface MenuOption {
    ConsoleOutput action();

    String getMenuOptionName();
}
