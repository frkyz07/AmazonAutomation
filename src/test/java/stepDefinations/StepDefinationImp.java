package stepDefinations;

import PageObjects.*;
import TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.runner.RunWith;
import org.testng.Assert;


import java.io.IOException;


public class StepDefinationImp extends BaseTest {

   public LandingPage landingPage;
   public ProductPage productPage;
   public CartsPage cartsPage;
   public PaymentPage paymentPage;
   public ThankYouPage thankYouPage;

    @Given("I landed on Ecommerce page")
    public void I_landed_on_Ecommerce_page() throws IOException {
        landingPage = launchDriver();

    }
    @Given("^Logged in with username (.+) and password (.+)$")
    public void Logged_in_with_username_and_password(String username, String password){
        productPage = landingPage.loginApplication(username, password);
    }
    @When("^i add the product (.+) to the cart$")
    public void I_add_the_product_to_the_card(String productName){
        cartsPage = productPage.addProductToCard(productName);

    }
    @And("^Checkout (.+) and submit the order$")
    public void Checkout_and_submit_the_order(String productName){
        Assert.assertTrue(cartsPage.goToCartsPageAndCheckTheOrder(productName));
        paymentPage = cartsPage.checkOut();
        thankYouPage = paymentPage.selectCountry("Turkey");

    }
    @Then("i verify the {string} message")
    public void i_verify_the_message(String string){
        Assert.assertEquals(thankYouPage.confirmationInformation(), string);
        System.out.println(thankYouPage.getElement());

    }
    @Then("^ \"([^\"]*)\" message is displayed$")
    public void something_message_is_displayed(String strArg1) throws Throwable {
        Assert.assertEquals(strArg1,landingPage.getErrorMessage());
        driver.close();

    }


}
