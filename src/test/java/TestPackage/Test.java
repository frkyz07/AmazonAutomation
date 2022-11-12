package TestPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
import java.util.List;

public class Test {


    public static void main(String[] args) {

        String productName = "ADIDAS ORIGINAL";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // TESTING WITH PAGE OBJECT MODEL

        LandingPage landingPage = new LandingPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartsPage cartsPage = new CartsPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);
        ThankYouPage thankYouPage = new ThankYouPage(driver);

        landingPage.goTo();
        landingPage.loginApplication("faruk@ayaz.com", "Faruk.1313");
        //List<WebElement> products = productPage.getProductsList();
        productPage.addProductToCard(productName);
        cartsPage.goToCartsPageAndCheckTheOrder(productName);
        paymentPage.selectCountry("Turkey");
        thankYouPage.confirmationInformation("THANKYOU FOR THE ORDER.");


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
