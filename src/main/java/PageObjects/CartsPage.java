package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartsPage extends AbstractComponent {

    WebDriver driver;

    public CartsPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".cartWrap")
    List<WebElement> carts;

    @FindBy(css = ".totalRow button")
    WebElement totalButton;

    By cardTagNameBy = By.tagName("h3");

    public boolean goToCartsPageAndCheckTheOrder(String productName) {

        boolean prodCart = carts.stream().anyMatch(cartProduct ->
                cartProduct.findElement(cardTagNameBy).getText().equals(productName));
        return prodCart;
    }

    public PaymentPage checkOut() {
        totalButton.click();
        PaymentPage paymentPage = new PaymentPage(driver);
        return paymentPage;
    }
}
