package org.example;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CartsPage extends AbstractComponent {

    WebDriver driver;

    public CartsPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li/button[@routerlink='/dashboard/cart']")
    WebElement cartsPage;

    @FindBy(css = ".cartWrap")
    List<WebElement> carts;

    @FindBy(css = ".totalRow button")
    WebElement totalButton;

    By cardTagNameBy = By.tagName("h3");

    public void goToCartsPageAndCheckTheOrder(String productName){

        cartsPage.click();
        boolean prodCart = carts.stream().anyMatch(cartProduct ->
                cartProduct.findElement(cardTagNameBy).getText().equals(productName));
        Assert.assertTrue(prodCart);
        totalButton.click();
    }
}
