package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class BasketAddedPage extends AbstractComponent {

    WebDriver driver;

    public BasketAddedPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

////span/input[@id='add-to-cart-button']
    @FindBy(xpath = "//*[@id='nav-cart-count']")
    WebElement goToTheBasketPage;

    @FindBy(xpath = "//*[@aria-labelledby=\"attachSiNoCoverage-announce\"]")
    WebElement noThanks;
    @FindBy(xpath = "//*[@id=\"attach-close_sideSheet-link\"]")
    WebElement exitButton;
    public BasketPage goToTheBasketPage() {

        //
        waitForTheElementToVisible(noThanks);
        noThanks.click();
        waitForTheElementToClickable(exitButton);
        exitButton.click();
        goToTheBasketPage.click();
        BasketPage basketPage = new BasketPage(driver);
        return basketPage;
    }
}
