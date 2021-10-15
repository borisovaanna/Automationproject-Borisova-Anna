package PageObject.Moodpanda;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CreateAccountPage {

    SelenideElement firstName = $(By.id("ContentPlaceHolderContent_TextBoxFirstName"));
    SelenideElement surname = $(By.id("ContentPlaceHolderContent_TextBoxSurname"));
    SelenideElement gender = $(By.id("ContentPlaceHolderContent_DropDownListGender"));
    SelenideElement yearOfBirth = $(By.id("ContentPlaceHolderContent_DropDownListYearOfBirth"));
    SelenideElement email = $(By.id("ContentPlaceHolderContent_TextBoxEmail"));
    SelenideElement password = $(By.id("ContentPlaceHolderContent_TextBoxPassword"));
    SelenideElement passwordConfirm = $(By.id("ContentPlaceHolderContent_TextBoxPasswordConfirm"));
    SelenideElement loginBtn = $(By.id("ContentPlaceHolderContent_ButtonLogin"));
    SelenideElement error = $(By.id("ContentPlaceHolderContent_MessageError"));

    public CreateAccountPage failureCreateAccountToMoodPanda() {
        loginBtn.click();
        error.should(Condition.matchText("Error: Please complete all fields correctly"));
        return this;
    }

    public CreateAccountPage createAccountToMoodPanda() {
        firstName.sendKeys("CD");
        surname.sendKeys("FG");
        gender.selectOption(1);
        yearOfBirth.selectOption("2000");
        email.sendKeys("cdfg@gmail.com");
        password.sendKeys("523");
        passwordConfirm.sendKeys("523");
        loginBtn.click();
        return this;
    }

}
