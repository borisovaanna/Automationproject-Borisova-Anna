package PageObject;

import driver.DriverCreation;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Properties.PropertyReader;

import java.util.Properties;

@Log4j2
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected Properties properties;

    protected BasePage(){
        this.driver = DriverCreation.getDriver();
        wait = new WebDriverWait(driver, 5);
        actions = new Actions(driver);
        properties = PropertyReader.getProperties();
    }

    protected void open(){
        open(properties.getProperty("url"));
    }

    protected void open(String url){
        log.info("Open page :: " + url);
        driver.get(url);
    }

    protected void enter(By element, CharSequence... charSequences){
        log.info("Enter in element :: " + element);
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(charSequences);
    }

    protected void click(By element){
        log.info("Click on element :: " + element);
        driver.findElement(element).click();
    }

    protected String getTextElement(By element){
        log.info("Find element :: " + element);
        return driver.findElement(element).getText();
    }

    protected void isDisplayed(By...elements){
        for(By element : elements){
            log.info("Verify that element :: " + element + " is displayed.");
            Assert.assertFalse(driver.findElements(element).isEmpty(), "Element :: " + elements + " is not exist.");
        }
    }

    public void pause(Integer seconds){
        try {
            long time = seconds * 1000;
            log.info("Sleep :: " + time);
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
