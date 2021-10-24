package PageObject.Moodpanda;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CreateAccountPage {

    SelenideElement loginBtn = $(By.id("ContentPlaceHolderContent_ButtonLogin"));
    SelenideElement error = $(By.id("ContentPlaceHolderContent_MessageError"));

    public CreateAccountPage failureCreateAccountToMoodPanda() {
        loginBtn.click();
        error.should(Condition.matchText("Error: Please complete all fields correctly"));
        return this;
    }

}
