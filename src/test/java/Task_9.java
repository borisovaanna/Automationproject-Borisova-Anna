import PageObject.*;
import driver.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task_9 extends BaseTest {
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();

    @BeforeMethod
    public void preconditions(){
        loginPage.openPage();
    }

    @Test(priority = 1)
    public void loginToApplicationStandard_Test(){
        loginPage.openPage()
                .verifyLoginPage()
                .loginToApplication("standard_user", "secret_sauce");
        productPage.verifyProductPage();
    }

    @Test(priority = 2)
    public void loginToApplicationProblem_Test() {
        loginPage.openPage()
                .verifyLoginPage()
                .loginToApplication("problem_user", "secret_sauce");
        productPage.verifyProductPage();
    }

    @Test(priority = 3)
    public void loginToApplicationLocked_Test() {
        loginPage.openPage()
                .verifyLoginPage()
                .loginToApplication("locked_out_user", "secret_sauce")
                .checkErrorText("Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(priority = 4)
    public void addSauceLabsBackpackInCart_Test() {
        loginPage.openPage()
                .verifyLoginPage()
                .loginToApplication("standard_user", "secret_sauce");
        productPage.verifyProductPage()
                .addToCart();
        cartPage.verifyCartPage()
                .checkItemQtyInCart("1")
                .checkItemDescriptionInCart("Sauce Labs Backpack");
    }

    @Test(priority = 5)
    public void removeSauceLabsBackpackInCart_Test() {
        loginPage.openPage()
                .verifyLoginPage()
                .loginToApplication("standard_user", "secret_sauce");
        productPage.verifyProductPage()
                .addToCart();
        cartPage.verifyCartPage()
                .removeItemFromCart();
        productPage.verifyProductPage()
                .checkItemRemoveFromCart("ADD TO CART");
    }

    @Test(priority = 6)
    public void checkout_Test() {
        loginPage.openPage()
                .verifyLoginPage()
                .loginToApplication("standard_user", "secret_sauce");
        productPage.verifyProductPage()
                .addToCart();
        cartPage.verifyCartPage()
                .checkout();
        checkoutPage.verifyCheckoutPage()
                .loginToCheckout("A", "B", "1");
        checkoutOverviewPage.verifyCheckoutOverviewPage()
                .checkItemName("Sauce Labs Backpack")
                .checkItemPrice("$29.99")
                .checkPayInfo("SauceCard #31337")
                .checkShipInfo("FREE PONY EXPRESS DELIVERY!")
                .checkItemTotalPrice("Item total: $29.99")
                .checkTax("Tax: $2.40")
                .checkTotalSum("Total: $32.39")
                .finish();
        checkoutCompletePage.verifyCheckoutCompletePage()
                .checkHeader("THANK YOU FOR YOUR ORDER")
                .checkText("Your order has been dispatched, and will arrive just as fast as the pony can get there!")
                .verifyCheckoutCompletePageLogo()
                .verifyBackHomeBtn();
    }
}
