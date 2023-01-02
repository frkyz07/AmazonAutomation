package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage extends AbstractComponent {

    WebDriver driver;

    public BasketPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span/input[@name='proceedToRetailCheckout']")
    WebElement checkOutButton;



    public SignInPage clickCheckOutButton() {

        waitForTheElementToClickable(checkOutButton);
        checkOutButton.click();
        SignInPage signInPage = new SignInPage(driver);
        return signInPage;
    }

}
