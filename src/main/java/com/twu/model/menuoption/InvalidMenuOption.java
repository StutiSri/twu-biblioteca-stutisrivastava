package com.twu.model.menuoption;

public class InvalidMenuOption implements MenuOption {
    public static final String ERROR_MESSAGE = "Invalid Menu Option Selected";

    @Override
    public String toString() {
        return ERROR_MESSAGE;
    }
}
