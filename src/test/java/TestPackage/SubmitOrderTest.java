package TestPackage;

import PageObjects.CartsPage;
import PageObjects.PaymentPage;
import PageObjects.ProductPage;
import PageObjects.ThankYouPage;
import TestComponents.BaseTest;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SubmitOrderTest extends BaseTest {

    @Test
    public void submitOrder() throws IOException {

        String productName = "ADIDAS ORIGINAL";
        // TESTING WITH PAGE OBJECT MODEL

        ProductPage productPage = landingPage.loginApplication("faruk@ayaz.com", "Faruk.1313");
        CartsPage cartsPage = productPage.addProductToCard(productName);
        Assert.assertTrue(cartsPage.goToCartsPageAndCheckTheOrder(productName));
        PaymentPage paymentPage = cartsPage.checkOut();
        ThankYouPage thankYouPage = paymentPage.selectCountry("Turkey");
        Assert.assertEquals(thankYouPage.confirmationInformation(), "THANKYOU FOR THE ORDER.");
        System.out.println(thankYouPage.getElement());

        /* TESTING WITHOUT PAGE OBJECT MODEL
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

          WebElement prod = products.stream().filter(product ->
                         product.findElement(By.tagName("b")).getText().equals(productName)).
                 findFirst().orElse(null);

        System.out.println(prod.getText());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

        driver.findElement(By.xpath("//li/button[@routerlink='/dashboard/cart']")).click();

        List<WebElement> carts = driver.findElements(By.cssSelector(".cartWrap"));
        boolean prodCart = carts.stream().anyMatch(cartProduct ->
                cartProduct.findElement(By.tagName("h3")).getText().equals(productName));
        Assert.assertTrue(prodCart);
        driver.findElement(By.cssSelector(".totalRow button")).click();


        driver.findElement(By.xpath("//div/input[@placeholder='Select Country']")).sendKeys("tur");
        driver.findElement(By.xpath("//*[contains(text(),'Turkey')]")).click();
        driver.findElement(By.cssSelector(".action__submit")).click();

        String someText = driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(someText.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        System.out.println(driver.findElements(By.xpath("//td/label[@class='ng-star-inserted']")).get(0).getText());
        driver.close();*/

    }

}
