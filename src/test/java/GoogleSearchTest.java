import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest {

    @Test
    public void test1(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.by");
        driver.findElement(By.name("q")).sendKeys("Привет мир", Keys.ENTER);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//h3)[12]"))).perform();
        driver.findElement(By.xpath("(//h3)[12]")).click();
        Assert.assertEquals(driver.findElement(By.id("firstHeading")).getText(), "Hello, world!");
        driver.quit();
    }

    @Test
    public void test2(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.by");
        driver.findElement(By.name("q")).sendKeys("//", Keys.ENTER);
        Assert.assertEquals(driver.findElement(By.xpath("(//p)[1]")).getText(), "По запросу // ничего не найдено. ");
        Assert.assertEquals(driver.findElement(By.xpath("(//p)[2]")).getText(), "Рекомендации:");
        Assert.assertEquals(driver.findElement(By.xpath("(//ul/li)[1]")).getText(), "Убедитесь, что все слова написаны без ошибок.");
        Assert.assertEquals(driver.findElement(By.xpath("(//ul/li)[2]")).getText(), "Попробуйте использовать другие ключевые слова.");
        Assert.assertEquals(driver.findElement(By.xpath("(//ul/li)[3]")).getText(), "Попробуйте использовать более популярные ключевые слова.");
        driver.quit();
    }

}
