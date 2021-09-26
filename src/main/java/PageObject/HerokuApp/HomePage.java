package PageObject.HerokuApp;

import PageObject.Saucedemo.BasePage;
import org.openqa.selenium.By;
import java.util.Arrays;

public class HomePage extends BasePage {
    private By title = By.tagName("h1");
    private By subTitle = By.tagName("h2");

    private By getLink(HomePageLinksEnum homePageLinksEnum) {
        return By.linkText(homePageLinksEnum.getLinkText());
    }
    private By getLink(String homePageLinksEnum) {
        return By.linkText(homePageLinksEnum);
    }

    public HomePage openPage() {
        open("http://the-internet.herokuapp.com");
        return this;
    }

    public HomePage verifyHomePage() {
        isDisplayed(title, subTitle);
        Arrays.asList(HomePageLinksEnum.values()).forEach(homePageLinksEnum -> isDisplayed(getLink(homePageLinksEnum)));
        return this;
    }

    public HomePage clickLink(HomePageLinksEnum homePageLinksEnum) {
        click(getLink(homePageLinksEnum));
        return this;
    }
}
