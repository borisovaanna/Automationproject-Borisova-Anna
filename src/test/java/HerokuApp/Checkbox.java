package HerokuApp;

import PageObject.HerokuApp.DynamicControls;
import PageObject.HerokuApp.HomePage;
import driver.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static PageObject.HerokuApp.HomePageLinksEnum.DYNAMIC_CONTROLS;

public class Checkbox extends BaseTest {
    HomePage homePage = new HomePage();
    DynamicControls dynamicControls = new DynamicControls();

    @BeforeTest
    public void preconditions() {
        homePage.openPage()
                .verifyHomePage();
    }

    @Test
    public void dynamicControlsCheckbox_Test() {
        homePage.clickLink(DYNAMIC_CONTROLS);
        dynamicControls.verifyPageTitle()
                .clickRemoveBtn()
                .verifyElementTextAfterRemove("It's gone!")
                .verifyCheckboxIsNotVisible();
    }

}
