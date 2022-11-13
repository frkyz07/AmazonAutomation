package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPage extends AbstractComponent {

    WebDriver driver;

    public LandingPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement userPassword;

    @FindBy(id = "login")
    WebElement login;

    @FindBy(css = "[class*='flyInOut'")
    WebElement errorMessage;

    public ProductPage loginApplication(String email, String password) {
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        login.click();
        ProductPage productPage = new ProductPage(driver);
        return productPage;
    }
    public String getErrorMessage(){
        waitForTheWebElement(errorMessage);
        return errorMessage.getText();
    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/client/");
    }


}

