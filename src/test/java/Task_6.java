import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task_6 {
    private static WebDriver driver;
        @BeforeTest
        public void preconditions(){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com");
        }

        @Test
        public void test1(){
            driver.findElement(By.id("user-name")).clear();
            driver.findElement(By.name("password")).clear();
            driver.findElement(By.cssSelector(".submit-button.btn_action")).click();
            Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='Epic sadface: Username is required']")).isDisplayed());
            Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "Epic sadface: Username is required");
        }

        @Test
        public void test2(){
            driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys("secret_sauce");
            driver.findElement(By.xpath("//input[contains(@class,'submit')]")).click();
            Assert.assertEquals(driver.findElement(By.cssSelector("[class=title]")).getText(), "PRODUCTS");
        }

        @Test
        public void test3(){
            driver.findElement(By.cssSelector("[id|=user]")).sendKeys("standard_user");
            driver.findElement(By.xpath("//div[@class = \"form_group\"]//descendant::input[@id = \"password\"]")).sendKeys("secret_sauce");
            driver.findElement(By.cssSelector("input.submit-button.btn_action")).click();
            driver.findElement(By.xpath("//div[contains(text(),'Backpack')]")).click();
            driver.findElement(By.cssSelector("[id^=add]")).click();
            driver.findElement(By.className("shopping_cart_link")).click();
            Assert.assertEquals(driver.findElement(By.cssSelector("[class$=name]")).getText(), "Sauce Labs Backpack");
            Assert.assertEquals(driver.findElement(By.cssSelector("[class*=inventory_item_p]")).getText(), "$29.99");
        }

        @Test
        public void test4(){
            driver.findElement(By.xpath("//input[contains(@class,'form') and @placeholder=\"Username\"]")).sendKeys("standard_user");
            driver.findElement(By.xpath("//div[@class = \"error-message-container\"]//preceding::input[@id = \"password\"]")).sendKeys("secret_sauce");
            driver.findElement(By.cssSelector("[class ~= submit-button]")).click();
            driver.findElement(By.xpath("//div[@class = \"inventory_item_label\"]//following::button[@name = \"add-to-cart-sauce-labs-fleece-jacket\"]")).click();
            driver.findElement(By.xpath("//div[@class = \"inventory_item_label\"]//following::button[@name = \"add-to-cart-sauce-labs-onesie\"]")).click();
            driver.findElement(By.className("shopping_cart_link")).click();
            driver.findElement(By.cssSelector(".cart_footer .btn.btn_action.btn_medium.checkout_button")).click();
            driver.findElement(By.xpath("//div[@class = \"checkout_info\"]//ancestor::form//div[@class = \"form_group\"]//input[@id = \"first-name\"]")).sendKeys("A");
            driver.findElement(By.xpath("//div[@class = \"checkout_info\"]//ancestor::form//div[@class = \"form_group\"]//input[@id = \"last-name\"]")).sendKeys("B");
            driver.findElement(By.xpath("//div[@class = \"checkout_info\"]//ancestor::form//div[@class = \"form_group\"]//input[@id = \"postal-code\"]")).sendKeys("1");
            driver.findElement(By.xpath("//button[@id = \"cancel\"]//parent::div//input")).click();
            Assert.assertEquals(driver.findElement(By.cssSelector(".summary_total_label")).getText(), "Total: $62.62");
        }

        @Test
        public void test5(){
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[contains(@class,'submit')]")).click();
        driver.findElement(By.linkText("Facebook")).click();
    }

        @AfterTest
        public void postconditions(){
            driver.quit();
        }
    }
