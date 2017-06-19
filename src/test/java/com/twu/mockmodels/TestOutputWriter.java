package com.twu.mockmodels;

import com.twu.io.output.ConsoleOutput;
import com.twu.io.outputwriter.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class TestOutputWriter implements OutputWriter {

    ArrayList<ConsoleOutput> outputMessages;

    public TestOutputWriter(){
        outputMessages = new ArrayList<>();
    }

    @Override
    public void write(ConsoleOutput output) {
        outputMessages.add(output);
    }

    public ConsoleOutput getOutputForWelcomeMessage(){
        return outputMessages.get(0);
    }

    public ConsoleOutput getOutputForMenuAfterWelcomeMessage(){
        return outputMessages.get(1);
    }

    public List<ConsoleOutput> getOutputMessagesAfterUsersChoosesAMenuOption(){
        return outputMessages.subList(2, outputMessages.size());
    }

    public ConsoleOutput getLoginResult() {
        return outputMessages.get(4);
    }

    public ConsoleOutput getMenuAfterLogin() {
        return outputMessages.get(5);
    }

    public ConsoleOutput getOutput() {
        return outputMessages.get(0);
    }

    public ConsoleOutput getMenuAfterLogout() {
        return outputMessages.get(7);
    }
}
