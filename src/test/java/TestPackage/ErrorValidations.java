package TestPackage;

import TestComponents.BaseTest;
import PageObjects.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ErrorValidations extends BaseTest {

    @Test
    public void submitOrder() throws IOException {

        String productName = "ADIDAS ORIGINAL";
        // TESTING WITH PAGE OBJECT MODEL

        landingPage.loginApplication("faruk@ayasdaz.com", "Fasdaruk.1313");
        Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());

    }

}
