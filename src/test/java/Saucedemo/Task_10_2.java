package Saucedemo;

import PageObject.Saucedemo.LoginPage;
import PageObject.Saucedemo.ProductPage;
import PageObject.Saucedemo.ProductSortPage;
import driver.BaseTest;
import org.testng.annotations.*;

import static PageObject.Saucedemo.ProductSortPage.Links.*;

public class Task_10_2 extends BaseTest {
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    ProductSortPage productSortPage = new ProductSortPage();

    @BeforeClass(groups = "Tests about price sort")
    public void preconditions(){
        loginPage.openPage()
                .verifyLoginPage()
                .loginToApplication("standard_user", "secret_sauce");
        productPage.verifyProductPage();
    }

    @Test(priority = 1, groups = "Tests about price sort")
    public void Links_Test_LowToHigh() {
        productSortPage
                .clickProductSortContainer()
                .clicklinks(LOHI)
                .checkSortPrices();

    }

    @Test(priority = 2, groups = "Tests about price sort", dependsOnMethods = "Links_Test_LowToHigh")
    public void Links_Test_HighToLow() {
        productSortPage
                .clickProductSortContainer()
                .clicklinks(HILO)
                .checkReverseSortPrices();}

    @Test(priority = 3, dependsOnMethods = "Links_Test_ZA")
    public void Links_Test_AZ() {
        productSortPage
                .clickProductSortContainer()
                .clicklinks(AZ)
                .checkSortNames();
    }

    @Test(priority = 4)
    public void Links_Test_ZA() {
        productSortPage
                .clickProductSortContainer()
                .clicklinks(ZA)
                .checkReverseSortNames();
    }

    @AfterClass(groups = "Tests about price sort")
    public void postconditions(){
        closeDriver();
    }
}
