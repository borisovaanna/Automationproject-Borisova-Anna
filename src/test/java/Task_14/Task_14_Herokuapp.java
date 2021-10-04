package Task_14;

import PageObject.HerokuApp.LoginPage;
import Patterns.LoginBuilder;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task_14_Herokuapp extends BaseTest {
    LoginPage loginPage;
    LoginBuilder loginBuilder;

    @BeforeClass
    public void preconditions() {
        loginPage = new LoginPage(driver);
        loginBuilder = new LoginBuilder.Builder().withUsername("tomsmith").withPassword("SuperSecretPassword!").build();
        loginPage.openPage()
                .verifyLoginPage();
    }

    @Test()
    public void authToHerokuappWithBuilder_Test() {
        loginPage.authToApplication(loginBuilder)
                .verifySuccessText();
    }
}
