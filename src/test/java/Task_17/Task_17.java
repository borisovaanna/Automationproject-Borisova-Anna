package Task_17;

import PageObject.Moodpanda.AccountPage;
import PageObject.Moodpanda.CreateAccountPage;
import PageObject.Moodpanda.HomePage;
import PageObject.Moodpanda.LoginPage;
import driver.BaseTestSelenide;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Task_17 extends BaseTestSelenide {

    @Description ("Verify MoodPanda HomePage")
    @Test(priority = 1)
    public void verifyHomePage_Test(){
        get(HomePage.class)
                .checkImage()
                .checkBrandNameText()
                .checkBrandNameSubtext();
    }

    @Description ("Create user account on MoodPanda")
    @Test(priority = 3)
    public void createAccount_Test(){
        get(HomePage.class)
                .clickStartBtn();
        get(LoginPage.class)
                .clickCreateAccountBtn();
        get(CreateAccountPage.class)
                .createAccountToMoodPanda();
        get(AccountPage.class)
                .checkImageAfterReg()
                .checkAccountPageTextAfterReg();
    }

    @Description ("Try to create user account without data")
    @Test(priority = 2)
    public void createAccountWithFailure_Test(){
        get(HomePage.class)
                .clickStartBtn();
        get(LoginPage.class)
                .clickCreateAccountBtn();
        get(CreateAccountPage.class)
                .failureCreateAccountToMoodPanda();
    }

    @Description ("Login to MoodPanda")
    @Test(priority = 4)
    public void loginToMoodPanda_Test(){
        get(HomePage.class)
                .clickStartBtn();
        get(LoginPage.class)
                .loginToMoodpanda();
        get(AccountPage.class)
                .checkImagesAfterLog()
                .checkAccountPageTextAfterLog();
    }

    @AfterMethod
    public void post() {
        closeWebDriver();
    }
}
