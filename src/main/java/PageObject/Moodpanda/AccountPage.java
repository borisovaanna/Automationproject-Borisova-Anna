package PageObject.Moodpanda;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {

    @FindBy(id = "ContentPlaceHolderContent_MyMoodPandaNav1_ImageProfile")
    SelenideElement imageForVerifyReg;

    @FindBy(id = "dobDiv")
    SelenideElement textForVerifyReg;

    @FindBy(xpath = "//div[@class = \"media-content border-wide-10 rounded-top-corner\"]")
    SelenideElement textForVerify;

    @FindBy(xpath = "//a[@class = \"btn btn-xs btn-default pull-right\"]")
    SelenideElement btnReportAbuse;

    @FindBy(xpath = "//a[@class = \"btn btn-xs btn-danger pull-right\"]")
    SelenideElement btnCrisis;

    public AccountPage checkImageAfterReg() {
        this.imageForVerifyReg.shouldBe(Condition.exist);
        return this;
    }

    public AccountPage checkAccountPageTextAfterReg() {
        textForVerifyReg.should(Condition.matchText("You must be over 16 to use MoodPanda. You can download any of your existing data below, but you can no longer use our service for legal reasons."));
        return this;
    }

    public AccountPage checkAccountPageTextAfterLog() {
        textForVerify.should(Condition.matchText("Community. Be kind.\n" +
                "I'm in crisis\n" +
                "Report abuse"));
        return this;
    }

    public AccountPage checkImagesAfterLog() {
        this.btnReportAbuse.shouldBe(Condition.exist);
        this.btnCrisis.shouldBe(Condition.exist);
        return this;
    }
}
