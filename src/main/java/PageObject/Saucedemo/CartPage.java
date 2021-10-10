package PageObject.Saucedemo;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends BasePage {
    private By titleOfCart = By.xpath("//span[@class = \"title\"]");
    private By qtyLogo = By.xpath("//div[@class = \"cart_quantity_label\"]");
    private By descriptionLogo = By.xpath("//div[@class = \"cart_desc_label\"]");
    private By qty = By.xpath("//div[@class = \"cart_quantity\"]");
    private By description = By.xpath("//div[@class = \"inventory_item_name\"]");
    private By removeBtn = By.id("remove-sauce-labs-backpack");
    private By continueShopBtn = By.id("continue-shopping");
    private By checkoutBtn = By.cssSelector("#checkout");

    public CartPage verifyCartPage() {
        isDisplayed(titleOfCart, qtyLogo, descriptionLogo);
        return this;
    }

    public CartPage checkItemQtyInCart(String expectedText) {
        Assert.assertEquals(getTextElement(qty), expectedText);
        return this;
    }

    public CartPage checkItemDescriptionInCart(String expectedText) {
        Assert.assertEquals(getTextElement(description), expectedText);
        return this;
    }

    public CartPage removeItemFromCart() {
        click(removeBtn);
        click(continueShopBtn);
        return this;
    }

    public CartPage checkout() {
        click(checkoutBtn);
        return this;
    }

}

