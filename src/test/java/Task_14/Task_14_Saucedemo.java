package Task_14;

import PageObject.Saucedemo.LoginPage;
import PageObject.Saucedemo.ProductPage;
import Patterns.LoginBuilder;
import Patterns.LoginPage_PageFactory_Saucedemo;
import driver.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task_14_Saucedemo extends BaseTest {
    LoginPage_PageFactory_Saucedemo loginPage_pageFactory_saucedemo;
    LoginPage loginPage;
    ProductPage productPage;
    LoginBuilder loginBuilder;

    @BeforeMethod
    public void preconditions() {
        loginPage_pageFactory_saucedemo = new LoginPage_PageFactory_Saucedemo(driver);
        loginPage = new LoginPage(driver);
        loginBuilder = new LoginBuilder.Builder().withUsername("standard_user").withPassword("secret_sauce").build();
        productPage = new ProductPage(driver);
        loginPage.openPage()
                .verifyLoginPage();
    }

    @Test()
    public void authToSaucedemoWithBuilder_Test() {
        loginPage.authToApplication(loginBuilder);
        productPage.verifyProductPage();
    }

    @Test()
    public void authToSaucedemoWithPageFactory_Test() {
        loginPage_pageFactory_saucedemo.authToApp("standard_user", "secret_sauce");
        productPage.verifyProductPage();
    }
}
