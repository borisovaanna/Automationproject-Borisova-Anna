package driver;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import TestNG.Listener;

import static driver.DriverCreation.getDriver;

@Listeners(Listener.class)
public class BaseTest {
    public static WebDriver driver;

    @BeforeTest
    public void setUpDriver(ITestContext context){
        driver = getDriver();
    }
}

