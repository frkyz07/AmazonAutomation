package TestPackage;

import PageObjects.*;
import TestComponents.BaseTest;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class SubmitOrderTest extends BaseTest {

    String productName = "ADIDAS ORIGINAL";

    @Test(dataProvider = "getData", groups = {"Purchase"})
    public void submitOrder(HashMap<Object,Object> input ) throws IOException {

        // TESTING WITH PAGE OBJECT MODEL

        ProductPage productPage = landingPage.loginApplication(input.get("email"), input.get("password"));
        CartsPage cartsPage = productPage.addProductToCard(input.get("productName"));
        Assert.assertTrue(cartsPage.goToCartsPageAndCheckTheOrder(input.get("productName")));
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
    // check the product is displaying or not
    @Test(dependsOnMethods = {"submitOrder"})
    public void orderHistoryTest(){

        ProductPage productPage = landingPage.loginApplication("faruk@ayaz.com", "Faruk.1313");
        OrderPage orderPage = productPage.goToOrderPage();
        Assert.assertTrue(orderPage.goToCheckTheOrder(productName));
    }
    @DataProvider
    public Object[][] getData(){

        HashMap<Object,Object> map = new HashMap<Object,Object>();
        map.put("email","faruk@ayaz.com");
        map.put("password","Faruk.1313");
        map.put("productName","ADIDAS ORIGINAL");

        HashMap<Object,Object> map1 = new HashMap<Object,Object>();
        map1.put("email","frkyz07.13@gmail.com");
        map1.put("password","Faruk.123");
        map1.put("productName","ZARA COAT 3");

        return new Object[][] {{map},{map1}};
    }

}
