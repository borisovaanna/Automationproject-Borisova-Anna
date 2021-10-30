package PageObject.Booking;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class HotelsPage {
    @FindBy(xpath = "//div[@class = 'fde444d7ef _c445487e2'][1]")
    SelenideElement hotelName;

    @FindBy(xpath = "//div[@class = '_9c5f726ff bd528f9ea6'][1]")
    SelenideElement hotelScore;

    public HotelsPage checkHotelName() {
        hotelName.should(Condition.matchText("Dom Krus"));
        return this;
    }

    public HotelsPage checkHotelScore() {
        hotelScore.should(Condition.matchText("9.7"));
        return this;
    }
}
