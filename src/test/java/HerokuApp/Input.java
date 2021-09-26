package HerokuApp;

import PageObject.HerokuApp.DynamicControls;
import PageObject.HerokuApp.HomePage;
import driver.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static PageObject.HerokuApp.HomePageLinksEnum.DYNAMIC_CONTROLS;

public class Input extends BaseTest {
    HomePage homePage = new HomePage();
    DynamicControls dynamicControls = new DynamicControls();

    @BeforeTest
    public void precondition() {
        homePage.openPage()
                .verifyHomePage();
    }

    @Test
    public void dynamicControlsInput_Test() {
        homePage.clickLink(DYNAMIC_CONTROLS);
        dynamicControls.verifyPageTitle()
                .verifyInputIsDisabled()
                .clickInputBtn()
                .verifyElementTextAfterEnable("It's enabled!")
                .verifyInput();
    }

}
