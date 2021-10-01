package Saucedemo;

import PageObject.Saucedemo.CartPage;
import PageObject.Saucedemo.LoginPage;
import PageObject.Saucedemo.ProductPage;
import driver.BaseTest;
import TestNG.Retry;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task_10_1 extends BaseTest {
    LoginPage loginPage = new LoginPage(driver);
    ProductPage productPage = new ProductPage(driver);
    CartPage cartPage = new CartPage(driver);

    @BeforeTest
    public void preconditions(){
        loginPage.openPage()
                .verifyLoginPage()
                .loginToApplication("standard_user", "secret_sauce");
    }


    @Test(invocationCount = 3, timeOut = 3000, retryAnalyzer = Retry.class)
    public void addSauceLabsBackpackInCart_Test() throws InterruptedException {
        Thread.sleep(2000);
        productPage.verifyProductPage()
                .addToCart();
        cartPage.verifyCartPage()
                .removeItemFromCart();
    }
}
