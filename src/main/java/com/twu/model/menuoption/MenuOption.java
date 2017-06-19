package com.twu.model.menuoption;

import com.twu.io.output.ConsoleOutput;

public interface MenuOption {
    ConsoleOutput action();

    String getMenuOptionName();
}
