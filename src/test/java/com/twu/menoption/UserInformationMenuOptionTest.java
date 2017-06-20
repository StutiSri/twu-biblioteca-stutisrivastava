package com.twu.menoption;

import com.twu.io.InputOutputHandler;
import com.twu.io.output.ConsoleOutput;
import com.twu.mockmodels.TestInputReader;
import com.twu.mockmodels.TestOutputWriter;
import com.twu.mockmodels.TestUserLogin;
import com.twu.model.menuoption.UserInformationMenuOption;
import com.twu.model.user.Customer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserInformationMenuOptionTest {
    @Test
    public void shouldDisplayDetailsOfCustomer() {
        String libraryNumber = "CUS-TEST\n";
        String password = "test";
        TestInputReader inputReader = new TestInputReader(libraryNumber + password);
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(inputReader, new TestOutputWriter());
        TestUserLogin userLogin = new TestUserLogin(inputOutputHandler);
        Customer customer = (Customer) userLogin.login();
        UserInformationMenuOption userInformationMenuOption =
                new UserInformationMenuOption(customer);
        ConsoleOutput expectedOutput = getDetails(customer);

        ConsoleOutput output = userInformationMenuOption.action();

        assertEquals(expectedOutput, output);
    }

    private ConsoleOutput getDetails(Customer customer) {
        List<String> userData = new ArrayList<>();
        userData.add("Name : " + customer.getName());
        userData.add("Email : " + customer.getEmailAddress());
        userData.add("Phone Number : " + customer.getPhoneNumber());
        return new ConsoleOutput(userData);
    }
}
