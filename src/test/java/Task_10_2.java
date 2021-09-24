
import PageObject.LoginPage;
import PageObject.ProductPage;
import PageObject.ProductSortPage;
import driver.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.*;

import static PageObject.ProductSortPage.Links.*;

public class Task_10_2 extends BaseTest {
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    ProductSortPage productSortPage = new ProductSortPage();

    @Description("Check sort items")

    @BeforeClass(groups = "Tests about price sort")
    public void preconditions(){
        loginPage.openPage()
                .verifyLoginPage()
                .loginToApplication("standard_user", "secret_sauce");
        productPage.verifyProductPage();
    }

    @Step("Check sort items on price from low to high")
    @Test(priority = 1, groups = "Tests about price sort", dependsOnMethods = "Links_Test_AZ")
    public void Links_Test_LowToHigh() {
        productSortPage
                .clickProductSortContainer()
                .clicklinks(LOHI)
                .checkSortPrices();

    }

    @Step("Check sort items on price from high to low")
    @Test(priority = 2, groups = "Tests about price sort", dependsOnMethods = "Links_Test_LowToHigh")
    public void Links_Test_HighToLow() {
        productSortPage
                .clickProductSortContainer()
                .clicklinks(HILO)
                .checkReverseSortPrices();}

    @Step("Check sort items on name from A to Z")
    @Test(priority = 3, dependsOnMethods = "Links_Test_ZA")
    public void Links_Test_AZ() {
        productSortPage
                .clickProductSortContainer()
                .clicklinks(AZ)
                .checkSortNames();
    }

    @Step("Check sort items on name from Z to A")
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
