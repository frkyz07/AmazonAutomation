package org.example;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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

    public String confirmationInformation() {
        return someText.getText();
    }
    public String getElement(){
        return elementList.get(0).getText();
    }

}
