package com.twu.model.provider;

import com.twu.io.input.ConsoleInput;
import com.twu.io.inputreader.InputReader;
import com.twu.io.output.ConsoleOutput;
import com.twu.io.outputwriter.OutputWriter;
import com.twu.model.menuoption.CheckoutMovieMenuOption;
import com.twu.model.menuoption.MenuOption;
import com.twu.model.repository.Repository;

public class CheckoutMovieMenuOptionProvider implements MenuOptionProvider {
    private final InputReader inputReader;
    private final OutputWriter outputWriter;
    private final Repository movieRepository;
    private final String MENU_OPTION_NAME = "Checkout Movie";
    private final String MENU_OPTION = "5";
    
    public CheckoutMovieMenuOptionProvider(InputReader inputReader, OutputWriter outputWriter,
                                           Repository movieRepository) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.movieRepository = movieRepository;
    }

    @Override
    public String getMenuOption() {
        return MENU_OPTION;
    }

    @Override
    public MenuOption getMenu() {
        return new CheckoutMovieMenuOption(movieRepository, readMovieToBeCheckedOut());
    }

    @Override
    public String getMenuOptionName() {
        return MENU_OPTION_NAME;
    }

    private ConsoleInput readMovieToBeCheckedOut() {
        outputWriter.write(new ConsoleOutput("Enter title of the movie :- "));
        return inputReader.read();
    }
}
