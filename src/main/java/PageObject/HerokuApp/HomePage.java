package PageObject.HerokuApp;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By title = By.tagName("h1");
    private By subTitle = By.tagName("h2");

    private By getLink(HomePageLinksEnum homePageLinksEnum) {
        return By.linkText(homePageLinksEnum.getLinkText());
    }

    public HomePage verifyHomePage() {
        isDisplayed(title, subTitle);
        for (HomePageLinksEnum homePageLinksEnum : HomePageLinksEnum.values()){
            isDisplayed(getLink(homePageLinksEnum));
        }
        return this;
    }

    public HomePage clickLink(HomePageLinksEnum homePageLinksEnum) {
        click(getLink(homePageLinksEnum));
        return this;
    }
}
