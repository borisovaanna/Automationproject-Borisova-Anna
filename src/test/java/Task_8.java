import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task_8 {
    private static WebDriver driver;

    @BeforeTest
    public void preconditions() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///D:/Test-project/Automationproject-Borisova-Anna/src/task_8/index.html");
    }

    @Test // here select try
    public void test1(){
        List<WebElement> head = driver.findElements(By.xpath("//table//th[1]"));
        Map<String, List<String>> data = new HashMap<>();
        for (int index = 0; index < head.size(); index++) {
            List<String> columnData = new ArrayList<>();
            List<WebElement> columns = driver.findElements(By.xpath("//table//tr//following::tr//td[1]"));
            for (WebElement column : columns) {
                columnData.add(column.getText());
            }
            data.put(head.get(index).getText(), columnData);
        }
        data.forEach((k, v) -> System.out.println(k + " -> " + v));}

    @Test
    public void test2(){
        Select select = new Select(driver.findElement(By.cssSelector("#cars")));
        select.selectByIndex(2);
        driver.findElement(By.cssSelector("#username")).sendKeys("user");
        driver.findElement(By.cssSelector("#pwd")).sendKeys("password");
        driver.findElement(By.cssSelector("#submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id=\"main-message\"]//descendant::span")).getText(), "Не удалось получить доступ к файлу");
    }

    @Test
    public void test3(){
        Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),\"paragraph\")]")).getText(), "This is a paragraph.");
    }

    @Test
    public void test4(){
        driver.findElement(By.linkText("w3schools")).click();
        Assert.assertTrue(driver.findElement(By.id("cert_navbtn")).isDisplayed());
    }

    @Test
    public void test5(){
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt=\"W3Schools.com\"]")).isDisplayed());
    }

    @AfterTest
    public void postconditions() {
        driver.quit();
    }
}
