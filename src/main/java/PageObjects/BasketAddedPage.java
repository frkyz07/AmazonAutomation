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


    @FindBy(xpath = "//div/a[@aria-label='1 item in shopping basket']")
    WebElement goToTheBasketPage;

    public BasketPage goToTheBasketPage() {
        goToTheBasketPage.click();
        BasketPage basketPage = new BasketPage(driver);
        return basketPage;
    }
}
