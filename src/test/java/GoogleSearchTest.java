import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest {

    @Test
    public void test1(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.by");
        driver.findElement(By.name("q")).sendKeys("Hello world!", Keys.ENTER);
        Assert.assertEquals(driver.findElement(By.xpath("(//h3)[1]")).getText(), "Hello, world! Карта для тех, кто летает | МТБанк");
        driver.quit();
    }

    @Test
    public void test2(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.by");
        driver.findElement(By.name("q")).sendKeys("//", Keys.ENTER);
        Assert.assertEquals(driver.findElement(By.xpath("(//p)[1]")).getText(), "По запросу // ничего не найдено. ");
        driver.quit();
    }

}
