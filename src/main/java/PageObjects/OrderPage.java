package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends AbstractComponent {

    WebDriver driver;

    public OrderPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "tr td:nth-child(3)")
    List<WebElement> ordersProductNames;

    @FindBy(css = ".totalRow button")
    WebElement totalButton;

    By cardTagNameBy = By.tagName("h3");

    public boolean goToCheckTheOrder(String productName) {

        boolean prodCart = ordersProductNames.stream().anyMatch(cartProduct ->
                cartProduct.findElement(cardTagNameBy).getText().equals(productName));
        return prodCart;
    }

    public PaymentPage checkOut() {
        totalButton.click();
        PaymentPage paymentPage = new PaymentPage(driver);
        return paymentPage;
    }
}
