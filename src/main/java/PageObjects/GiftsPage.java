package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftsPage extends AbstractComponent {

    WebDriver driver;

    public GiftsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//span/input[@id='sp-cc-accept']")
    WebElement acceptCookies;


    public WebElement personSelect(String keyword) {
        By personSelecter = By.xpath("(//div/span[contains(text(),'"+keyword+"')])[1]");
        return driver.findElement(personSelecter);
    }
    public WebElement categorySelect(String keyword) {
        By categorySelecter = By.xpath("(//div/ul/li/button[contains(text(),'"+keyword+"')])[1]");
        return driver.findElement(categorySelecter);
    }
    public WebElement productSelect(String keyword) {
        By productSelecter = By.xpath("(//div/span[contains(text(),'"+keyword+"')])[1]");
        return driver.findElement(productSelecter);
    }

    // for the "selectProduct" feature dynamism locators must change will check tomorrow
    public ProductPage selectProduct(String person, String category,String product) {

        acceptCookies.click();
        waitForTheElementToVisible(personSelect(person));
        personSelect(person).click();
        waitForTheElementToVisible(categorySelect(category));
        categorySelect(category).click();
        waitForTheElementToVisible(productSelect(product));
        productSelect(product).click();

        ProductPage productPage = new ProductPage(driver);
        return productPage;
    }
}
