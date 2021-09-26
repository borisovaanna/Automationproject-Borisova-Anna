package PageObject.Saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;

public class CheckoutCompletePage extends BasePage{
    private By titleOfCheckoutComplete = By.xpath("//span[@class = \"title\"]");
    private By header = By.cssSelector(".complete-header");
    private By text = By.cssSelector(".complete-text");
    private By logo = By.xpath("//img[@class = \"pony_express\"]");
    private By backHomeBtn = By.id("back-to-products");

    public CheckoutCompletePage verifyCheckoutCompletePage() {
        isDisplayed(titleOfCheckoutComplete);
        return this;
    }

    public CheckoutCompletePage checkHeader(String expectedText) {
        Assert.assertEquals(getTextElement(header), expectedText);
        return this;
    }

    public CheckoutCompletePage checkText(String expectedText) {
        Assert.assertEquals(getTextElement(text), expectedText);
        return this;
    }

    public CheckoutCompletePage verifyCheckoutCompletePageLogo() {
        isDisplayed(logo);
        return this;
    }

    public CheckoutCompletePage verifyBackHomeBtn() {
        isDisplayed(backHomeBtn);
        return this;
    }
}
