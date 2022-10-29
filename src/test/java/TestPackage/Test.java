package TestPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Test {


    public static void main(String[] args) {

        String productName = "ADIDAS ORIGINAL";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client/");

        driver.findElement(By.id("userEmail")).sendKeys("faruk@ayaz.com");
        driver.findElement(By.id("userPassword")).sendKeys("Faruk.1313");
        driver.findElement(By.id("login")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

        System.out.println(products.get(1).getText());

        WebElement prod = products.stream().filter(product ->
                product.findElement(By.tagName("b")).getText().equals(productName)).
                findFirst().orElse(null);

        prod.findElement(By.cssSelector(".w-10")).click();
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
        driver.close();

    }

}
