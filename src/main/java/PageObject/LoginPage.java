package PageObject;

import org.openqa.selenium.By;
import org.testng.Assert;
import static driver.DriverCreation.getDriver;

public class LoginPage extends BasePage{
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");
    private By errorTxt = By.xpath("//h3[@data-test = \"error\"]");

    public LoginPage openPage() {
        open("https://www.saucedemo.com/");
        return this;
    }

    public LoginPage verifyLoginPage() {
        isDisplayed(username, password, loginBtn);
        return this;
    }

    public LoginPage loginToApplication(String username, String password) {
        enter(this.username, username);
        enter(this.password, password);
        click(this.loginBtn);
        return this;
    }

    public LoginPage checkErrorText(String expectedText) {
        Assert.assertEquals(getTextElement(errorTxt), expectedText);
        return this;
    }
}
