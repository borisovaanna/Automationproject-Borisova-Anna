package Task_10;

import PageObject.Saucedemo.LoginPage;
import driver.BaseTest;
import TestNG.Listener;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(Listener.class)

public class Task_10 extends BaseTest {
    LoginPage loginPage = new LoginPage();

    @BeforeTest
    public void preconditions() {
        loginPage.openPage();
    }

    @DataProvider(name = "Данные для входа на сайт")
    public Object[][] inputForSwagLabs() {
        return new Object[][]{
                {"standard_user", "secret_sauce", null},
                {"123", "123", "Epic sadface: Username and password do not match any user in this service"},
                {" ", " ", "Epic sadface: Username is required"},
                {"@_", "!&", "Epic sadface: Username and password do not match any user in this service"},
                {"user", "sauce", "Epic sadface: Username and password do not match any user in this service"},
                {"КрПне", "ьтРа", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Description("Login to app")
    @Test(dataProvider = "Данные для входа на сайт", expectedExceptions = AssertionError.class)
    public void loginToApplication_Test(String username, String password, String error) {
        if (error == null || error == "Epic sadface: Username is required") {
            loginPage.openPage()
                    .verifyLoginPage()
                    .loginToApplication(username, password);
            Assert.assertEquals(error, "Epic sadface: Username is required");
        } else if(error == "Epic sadface: Username and password do not match any user in this service"){
            loginPage.openPage()
                    .verifyLoginPage()
                    .loginToApplication(username, password);
            Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");}
    }

}
