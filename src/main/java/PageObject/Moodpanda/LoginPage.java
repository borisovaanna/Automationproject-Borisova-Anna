package PageObject.Moodpanda;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    SelenideElement createAccountBtn = $(By.id("ContentPlaceHolderContent_HyperLinkRegister"));
    SelenideElement email = $(By.id("ContentPlaceHolderContent_TextBoxEmail"));
    SelenideElement password = $(By.id("ContentPlaceHolderContent_TextBoxPassword"));
    SelenideElement loginBtn = $(By.id("ContentPlaceHolderContent_ButtonLogin"));

    public LoginPage clickCreateAccountBtn() {
        createAccountBtn.click();
        return this;
    }

    public LoginPage loginToMoodpanda() {
        email.sendKeys("aaa@gmail.com");
        password.sendKeys("1");
        loginBtn.click();
        return this;
    }
}
