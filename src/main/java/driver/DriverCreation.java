package driver;

import Properties.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverCreation {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver() {
        if (driver.get() == null) {
            createDriver();
        }
    }

    public static void createDriver() {
        if (PropertyReader.getProperties().containsKey("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments(PropertyReader.getProperties().getProperty("chrome").split(";"));
            WebDriver webDriver = new ChromeDriver(chromeOptions);
            driver.set(webDriver);
        } else if (PropertyReader.getProperties().containsKey("mozilla")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        } else {
            WebDriverManager.iedriver().setup();
            driver.set(new InternetExplorerDriver());
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().close();
            driver.get().quit();
            driver.remove();
        }
    }
}
