package org.example;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PaymentPage extends AbstractComponent {

    WebDriver driver;

    public PaymentPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/input[@placeholder='Select Country']")
    WebElement countryInput;

    @FindBy(xpath = "//*[contains(text(),'Turkey')]")
    List<WebElement> carts;

    @FindBy(css = ".action__submit")
    WebElement actionButton;

    public ThankYouPage selectCountry(String countryName) {

        countryInput.sendKeys(countryName);
        driver.findElement(By.xpath("//*[contains(text(),'" + countryName + "')]")).click();
        actionButton.click();
        ThankYouPage thankYouPage = new ThankYouPage(driver);
        return thankYouPage;
    }

}
