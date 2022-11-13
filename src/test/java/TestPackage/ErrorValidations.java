package TestPackage;

import PageObjects.CartsPage;
import TestComponents.BaseTest;
import PageObjects.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ErrorValidations extends BaseTest {

    String productName = "ADIDAS ORIGINAL";
    @Test
    public void loginError() throws IOException {

        landingPage.loginApplication("faruk@ayasdaz.com", "Fasdaruk.1313");
        Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());

    }
    @Test
    public void productNameError() {
        ProductPage productPage = landingPage.loginApplication("faruk@ayaz.com", "Faruk.1313");
        CartsPage cartsPage = productPage.addProductToCard(productName);

        String wrongProductName = "something";
        Assert.assertFalse(cartsPage.goToCartsPageAndCheckTheOrder(wrongProductName));

    }



}
