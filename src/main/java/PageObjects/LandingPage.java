package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {

    WebDriver driver;

    public LandingPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/a[@data-csa-c-content-id='nav_cs_giftfinder']")
    WebElement giftIdeas;

    public GiftsPage goToGiftIdeas() {
        giftIdeas.click();
        GiftsPage giftsPage = new GiftsPage(driver);
        return giftsPage;
    }

    public void goTo() {
        driver.get("https://www.amazon.co.uk/");
    }
}

