package Task_12_HerokuApp;

import PageObject.HerokuApp.DynamicControls;
import PageObject.HerokuApp.HomePage;
import PageObject.HerokuApp.HomePageLinksEnum;
import PageObject.HerokuApp.LoginPage;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task_12 extends BaseTest {
    DynamicControls dynamicControls;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeClass
    public void precondition() {
        dynamicControls = new DynamicControls(driver);
        homePage =  new HomePage(driver);
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        homePage.verifyHomePage().clickLink(HomePageLinksEnum.DYNAMIC_CONTROLS);
    }

    @Test
    public void dynamicControlsCheckbox_Test() {
        dynamicControls.verifyPageTitle()
                .clickRemoveBtn()
                .verifyElementTextAfterRemove("It's gone!")
                .verifyCheckboxIsNotVisible();
    }

    @Test
    public void dynamicControlsInput_Test() {
        dynamicControls.verifyPageTitle()
                .verifyInputIsDisabled()
                .clickInputBtn()
                .verifyElementTextAfterEnable("It's enabled!")
                .verifyInput();
    }

}
