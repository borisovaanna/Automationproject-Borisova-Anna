package PageObject.HerokuApp;

import NewPatterns.LoginBuilder;
import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.cssSelector(".radius");
    private By successTxt = By.cssSelector(".flash.success");

    public LoginPage openPage() {
        open();
        return this;
    }

    public LoginPage verifyLoginPage() {
        isDisplayed(username, password, loginBtn);
        return this;
    }

    public LoginPage clickLoginBtn() {
        click(this.loginBtn);
        return this;
    }

    public LoginPage enterUsername(String username) {
        enter(this.username, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        enter(this.password, password);
        return this;
    }

    public LoginPage loginToApplication(String username, String password) {
        enter(this.username, username);
        enter(this.password, password);
        click(this.loginBtn);
        return this;
    }

    public LoginPage authToApp(LoginBuilder loginBuilder) {
        enterUsername(loginBuilder.getUsername());
        enterPassword(loginBuilder.getPassword());
        clickLoginBtn();
        return this;
    }

    public LoginPage verifySuccessText() {
        isDisplayed(successTxt);
        return this;
    }
}
