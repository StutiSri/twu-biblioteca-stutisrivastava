package com.twu.provider;

import com.twu.mockmodels.TestBookRepository;
import com.twu.mockmodels.TestInputReader;
import com.twu.mockmodels.TestOutputWriter;
import com.twu.model.provider.CheckoutBookMenuOptionProvider;
import org.junit.Test;

public class CheckoutBookMenuOptionProviderTest {
    @Test
    public void shouldThrowExceptionForInvalidLogin(){
        String libraryNumber = "STU-9176\n";
        String password = "hello";
        TestInputReader inputReader = new TestInputReader(libraryNumber + password);
        CheckoutBookMenuOptionProvider checkoutMenuOptionProvider
                = new CheckoutBookMenuOptionProvider(inputReader, new TestOutputWriter(), new TestBookRepository());

        //checkoutMenuOptionProvider.userLogin();
    }
}
