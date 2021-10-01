package PageObject.Saucedemo;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");
    private By errorTxt = By.xpath("//h3[@data-test = \"error\"]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openPage() {
        open();
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
