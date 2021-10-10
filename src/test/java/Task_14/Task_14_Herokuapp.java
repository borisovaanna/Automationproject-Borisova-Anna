package Task_14;

import PageObject.HerokuApp.LoginPage;
import NewPatterns.LoginBuilder;
import driver.BaseTest;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Log4j2
public class Task_14_Herokuapp extends BaseTest {
    LoginPage loginPage;
    LoginBuilder loginBuilder;

    //"tomsmith", "SuperSecretPassword!"

    @BeforeClass
    public void preconditions() {
        loginPage = new LoginPage();
        loginBuilder = LoginBuilder.builder().username("tomsmith").password("SuperSecretPassword!").build();
        loginPage.openPage()
                .verifyLoginPage();
    }

    @Test()
    public void authToHerokuapp_Test() {
        loginPage.authToApp(loginBuilder)
                .verifySuccessText();
        log.info(loginBuilder);
    }
}
