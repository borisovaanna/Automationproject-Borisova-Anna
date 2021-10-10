package NewPatterns;

import PageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PageFactory_Saucedemo extends BasePage {

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    public LoginPage_PageFactory_Saucedemo() {
        PageFactory.initElements(driver, this);
    }

    public LoginPage_PageFactory_Saucedemo authToApp(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginBtn.click();
        return this;
    }
}
