package PageObject.Moodpanda;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    @FindBy(css = ".img-responsive.img-centered")
    SelenideElement img;

    @FindBy(xpath = "//div[@class = 'brand-name hidden-xs hidden-height-670']")
    SelenideElement brandNameText;

    @FindBy(xpath = "//div[@class = 'brand-name-subtext']")
    SelenideElement brandNameSubtext;

    @FindBy(xpath = "//a[@class = 'btn btn-outline-light hidden-height-570 page-scroll']")
    SelenideElement startBtn;

    public HomePage checkImage() {
        this.img.shouldBe(Condition.exist);
        return this;
    }

    public HomePage checkBrandNameText() {
        brandNameText.should(Condition.matchText("MoodPanda"));
        return this;
    }

    public HomePage checkBrandNameSubtext() {
        brandNameSubtext.should(Condition.matchText("track your mood & get anonymous support"));
        return this;
    }

    public HomePage clickStartBtn() {
        startBtn.click();
        return this;
    }
}
