package Task_14;

import NewPatterns.LoginBuilder;
import PageObject.Saucedemo.LoginPage;
import PageObject.Saucedemo.ProductPage;
import NewPatterns.LoginPage_PageFactory_Saucedemo;
import driver.BaseTest;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Log4j2
public class Task_14_Saucedemo extends BaseTest {
    LoginPage_PageFactory_Saucedemo loginPage_pageFactory_saucedemo;
    LoginPage loginPage;
    ProductPage productPage;
    LoginBuilder loginBuilder;

    //"standard_user", "secret_sauce"

    @BeforeMethod
    public void preconditions() {
        loginPage_pageFactory_saucedemo = new LoginPage_PageFactory_Saucedemo();
        loginPage = new LoginPage();
        loginBuilder = LoginBuilder.builder().username("standard_user").password("secret_sauce").build();
        productPage = new ProductPage();
        loginPage.openPage()
                .verifyLoginPage();
    }

    @Test()
    public void authToSaucedemoWithBuilder_Test() {
        loginPage.authToApp(loginBuilder);
        productPage.verifyProductPage();
        log.info(loginBuilder);
    }

    @Test()
    public void authToSaucedemoWithPageFactory_Test() {
        loginPage_pageFactory_saucedemo.authToApp("standard_user", "secret_sauce");
        productPage.verifyProductPage();
    }
}
