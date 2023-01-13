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

    @FindBy(xpath = "//*[@id='buy-now-button']")
    WebElement buyNow;

    public SignInPage buyProduct() {
        waitForTheElementToVisible(buyNow);
        buyNow.click();
        SignInPage signInPage = new SignInPage(driver);
        return signInPage;
    }
}

