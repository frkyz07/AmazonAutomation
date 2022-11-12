package org.example;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ThankYouPage extends AbstractComponent {

    WebDriver driver;

    public ThankYouPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".hero-primary")
    WebElement someText;

    @FindBy(xpath = "//td/label[@class='ng-star-inserted']")
    List<WebElement> elementList;

    public void confirmationInformation(String confirmedText) {

        String text = someText.getText();
        Assert.assertTrue(text.equalsIgnoreCase(confirmedText));
        System.out.println(elementList.get(0).getText());
    }
}
