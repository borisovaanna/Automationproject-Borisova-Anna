package PageObject.Saucedemo;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductPage extends BasePage {
    private By title = By.cssSelector(".title");
    private By logo = By.cssSelector(".app_logo");
    private By filter = By.tagName("select");
    private By addBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By cartBtn = By.xpath("//a[@class = \"shopping_cart_link\"]");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage verifyProductPage() {
        isDisplayed(title, logo, filter);
        return this;
    }

    public ProductPage addToCart() {
        click(addBtn);
        click(cartBtn);
        return this;
    }

    public ProductPage checkItemRemoveFromCart(String expectedText) {
        Assert.assertEquals(getTextElement(addBtn), expectedText);
        return this;
    }
}
