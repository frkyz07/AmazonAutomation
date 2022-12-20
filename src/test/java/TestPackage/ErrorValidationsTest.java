package TestPackage;

import PageObjects.CartsPage;
import TestComponents.BaseTest;
import PageObjects.ProductPage;
import TestComponents.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ErrorValidationsTest extends BaseTest {

    String productName = "ADIDAS ORIGINAL";
    @Test(retryAnalyzer = Retry.class)
    public void loginError() throws IOException {

        landingPage.loginApplication("faruk@ayasdaz.com", "Fasdaruk.1313");
        Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
    }
    @Test(groups = "ErrorHandling")
    public void productNameError() {
        ProductPage productPage = landingPage.loginApplication("faruk@ayaz.com", "Faruk.1313");
        CartsPage cartsPage = productPage.addProductToCard(productName);

        String wrongProductName = "something";
        Assert.assertFalse(cartsPage.goToCartsPageAndCheckTheOrder(wrongProductName));

    }

}
