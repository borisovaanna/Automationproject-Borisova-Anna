package PageObject;

import org.openqa.selenium.By;
import org.testng.Assert;

import static driver.DriverCreation.getDriver;

public class BasePage {
    protected void open(String url){
        getDriver().get(url);
    }

    protected void enter(By element, CharSequence... charSequences){
        getDriver().findElement(element).clear();
        getDriver().findElement(element).sendKeys(charSequences);
    }

    protected void click(By element){
        getDriver().findElement(element).click();
    }

    protected String getTextElement(By element){
        return getDriver().findElement(element).getText();
    }

    protected void isDisplayed(By...elements){
        for(By element : elements){
            Assert.assertTrue(getDriver().findElement(element).isDisplayed(), "Element :: " + elements + " is not exist.");
        }
    }
}
