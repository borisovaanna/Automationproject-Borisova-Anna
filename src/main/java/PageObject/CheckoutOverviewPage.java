package PageObject;

import org.openqa.selenium.By;
import org.testng.Assert;

public class CheckoutOverviewPage extends BasePage{
    private By titleOfCheckoutOverview = By.xpath("//span[@class = \"title\"]");
    private By itemName = By.xpath("//div[@class = \"inventory_item_name\"]");
    private By itemPrice = By.xpath("//div[@class = \"inventory_item_price\"]");
    private By payInfo = By.xpath("//div[@class = \"summary_value_label\"][1]");
    private By shipInfo = By.xpath("//div[@class = \"summary_value_label\"][2]");
    private By itemTotalPrice = By.xpath("//div[@class = \"summary_subtotal_label\"]");
    private By tax = By.xpath("//div[@class = \"summary_tax_label\"]");
    private By totalSum = By.xpath("//div[@class = \"summary_total_label\"]");
    private By finishBtm = By.id("finish");

    public CheckoutOverviewPage verifyCheckoutOverviewPage() {
        isDisplayed(titleOfCheckoutOverview);
        return this;
    }

    public CheckoutOverviewPage checkItemName(String expectedText) {
        Assert.assertEquals(getTextElement(itemName), expectedText);
        return this;
    }

    public CheckoutOverviewPage checkItemPrice(String expectedText) {
        Assert.assertEquals(getTextElement(itemPrice), expectedText);
        return this;
    }

    public CheckoutOverviewPage checkPayInfo(String expectedText) {
        Assert.assertEquals(getTextElement(payInfo), expectedText);
        return this;
    }

    public CheckoutOverviewPage checkShipInfo(String expectedText) {
        Assert.assertEquals(getTextElement(shipInfo), expectedText);
        return this;
    }

    public CheckoutOverviewPage checkItemTotalPrice(String expectedText) {
        Assert.assertEquals(getTextElement(itemTotalPrice), expectedText);
        return this;
    }

    public CheckoutOverviewPage checkTax(String expectedText) {
        Assert.assertEquals(getTextElement(tax), expectedText);
        return this;
    }

    public CheckoutOverviewPage checkTotalSum(String expectedText) {
        Assert.assertEquals(getTextElement(totalSum), expectedText);
        return this;
    }

    public CheckoutOverviewPage finish() {
        click(finishBtm);
        return this;
    }
}
