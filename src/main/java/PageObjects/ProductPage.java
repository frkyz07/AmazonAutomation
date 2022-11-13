package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends AbstractComponent {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy(css = ".ng-animating")
    WebElement animatingBy;

    @FindBy(xpath = "//li/button[@routerlink='/dashboard/cart']")
    WebElement cartsPage;
    By productsBy = By.cssSelector(".mb-3");
    By addCardBy = By.cssSelector(".w-10");
    By toastContainerBy = By.id("toast-container");


    public List<WebElement> getProductsList() {

        waitForTheElement(productsBy);
        return products;
    }

    public WebElement getProductByName(String productName) {

        WebElement prod = getProductsList().stream().filter(product ->
                        product.findElement(By.tagName("b")).getText().equals(productName)).
                findFirst().orElse(null);
        return prod;
    }

    public CartsPage addProductToCard(String productName) {

        WebElement prod = getProductByName(productName);
        prod.findElement(addCardBy).click();
        waitForTheElement(toastContainerBy);
        waitForTheElementToInvisible(animatingBy);
        cartsPage.click();
        CartsPage cartsPage = new CartsPage(driver);
        return cartsPage;
    }
}

