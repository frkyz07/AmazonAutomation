package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends AbstractComponent {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span/input[@id='add-to-cart-button']")
    WebElement addToTheBasket;

    public BasketAddedPage addProductToBasket() {
        waitForTheElementToVisible(addToTheBasket);
        addToTheBasket.click();
        BasketAddedPage basketAddedPage = new BasketAddedPage(driver);
        return basketAddedPage;
    }
}

