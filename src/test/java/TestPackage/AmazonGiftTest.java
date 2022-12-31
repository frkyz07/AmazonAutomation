package TestPackage;

import TestComponents.BaseTest;
import TestComponents.Retry;
import org.testng.annotations.Test;

public class AmazonGiftTest extends BaseTest {

    //retryAnalyzer = Retry.class
    @Test()
    public void giftTest(){
        landingPage.goToGiftIdeas().selectProduct().addProductToBasket().goToTheBasketPage().clickCheckOutButton();
    }
}
