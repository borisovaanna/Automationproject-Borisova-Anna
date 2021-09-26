package PageObject.Saucedemo;

import org.openqa.selenium.By;

public class CheckoutPage extends BasePage{
    private By titleOfCheckout = By.xpath("//span[@class = \"title\"]");
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By zipCode = By.id("postal-code");
    private By continueBtn = By.id("continue");

    public CheckoutPage verifyCheckoutPage() {
        isDisplayed(titleOfCheckout);
        return this;
    }

    public CheckoutPage loginToCheckout(String firstName, String lastName, String zipCode) {
        enter(this.firstName, firstName);
        enter(this.lastName, lastName);
        enter(this.zipCode, zipCode);
        click(this.continueBtn);
        return this;
    }

}
