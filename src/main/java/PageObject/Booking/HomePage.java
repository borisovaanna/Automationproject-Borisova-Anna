package PageObject.Booking;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    @FindBy(xpath = "//input[@id = 'ss']")
    SelenideElement hotel;

    @FindBy(xpath = "//span[@class = 'sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']")
    SelenideElement chooseDate;

    @FindBy(xpath = "//td[@data-date = '2021-11-01']")
    SelenideElement firstDate;

    @FindBy(xpath = "//td[@data-date = '2021-11-30']")
    SelenideElement lastDate;

    @FindBy(xpath = "//button[@class = 'sb-searchbox__button  b-button b-button_primary b-searchbox-button b-searchbox-button_legacy']")
    SelenideElement searchBtn;

    public HomePage enterHotel() {
        hotel.sendKeys("Dom Krus");
        return this;
    }

    public HomePage enterPeriod() {
        chooseDate.click();
        firstDate.click();
        lastDate.click();
        return this;
    }

    public HomePage searchHotel() {
        searchBtn.click();
        return this;
    }
}
