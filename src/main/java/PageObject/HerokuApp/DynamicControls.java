package PageObject.HerokuApp;

import PageObject.Saucedemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static PageObject.HerokuApp.HomePageLinksEnum.DYNAMIC_CONTROLS;
import static driver.DriverCreation.getDriver;

public class DynamicControls extends BasePage {
    private By removeBtn = By.cssSelector("#checkbox-example>button");
    private By textBackFromRemove = By.cssSelector("#checkbox-example>p");
    private By title = By.tagName("h4");
    private By checkbox = By.xpath("//div[@id = \"checkbox\"]");
    private By input = By.xpath("//input[@type = \"text\"]");
    private By enableBtn = By.cssSelector("#input-example>button");
    private By textBackFromEnable = By.cssSelector("#input-example>p");

    public DynamicControls verifyPageTitle() {
        Assert.assertEquals(getTextElement(title), DYNAMIC_CONTROLS.getLinkText());
        return this;
    }

    public DynamicControls clickRemoveBtn() {
        click(removeBtn);
        return this;
    }

    public DynamicControls verifyElementTextAfterRemove(String text) {
        wait.until(ExpectedConditions.textToBe(textBackFromRemove, text));
        return this;
    }

    public DynamicControls verifyCheckboxIsNotVisible() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkbox));
        return this;
    }

    public DynamicControls verifyInputIsDisabled() {
        Assert.assertFalse(getDriver().findElement(input).isEnabled());
        return this;
    }

    public DynamicControls clickInputBtn() {
        click(enableBtn);
        return this;
    }

    public DynamicControls verifyElementTextAfterEnable(String text) {
        wait.until(ExpectedConditions.textToBe(textBackFromEnable, text));
        return this;
    }

    public DynamicControls verifyInput() {
        wait.until(ExpectedConditions.elementToBeClickable(input));
        return this;
    }

}
