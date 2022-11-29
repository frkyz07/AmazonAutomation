package AbstractComponents;

import PageObjects.CartsPage;
import PageObjects.OrderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {

    WebDriver driver;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "[routerlink*='cart']")
    WebElement cartHeader;

    @FindBy(css = "[routerlink*='myorders']")
    WebElement orderHeader;

    public void waitForTheWebElement(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public void waitForTheElement(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForTheElementToInvisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public CartsPage goToCartPage(){
        cartHeader.click();
        CartsPage cartsPage = new CartsPage(driver);
        return cartsPage;
    }
    public OrderPage goToOrderPage(){
        cartHeader.click();
        OrderPage orderPage = new OrderPage(driver);
        return orderPage;
    }


}
