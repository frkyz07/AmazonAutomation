package PageObjects;

import AbstractComponents.AbstractComponent;
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
    @FindBy(xpath = "(//div/span[contains(text(),'Women')])[1]")
    WebElement women;

    @FindBy(xpath = "(//div/ul/li/button[contains(text(),'Jewellery and Watches')])[1]")
    WebElement jewelleryAndWacthes;

    @FindBy(xpath = "(//div/span[contains(text(),'Earrings')])[1]")
    WebElement product;

    // for the "selectProduct" feature dynamism locators must change
    public ProductPage selectProduct() {

        acceptCookies.click();
        waitForTheElementToVisible(women);
        women.click();
        waitForTheElementToVisible(jewelleryAndWacthes);
        jewelleryAndWacthes.click();
        waitForTheElementToVisible(product);
        product.click();
        ProductPage productPage = new ProductPage(driver);
        return productPage;
    }
}
