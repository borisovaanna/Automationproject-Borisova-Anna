import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Task_5 {

    private static WebDriver driver;

    @BeforeTest
    public void preconditions() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
    }

    private void enter(String element, Integer value) {
        driver.findElement(By.name(element)).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), value.toString(), Keys.ENTER);
    }

    private Select select() {
        return new Select(driver.findElement(By.name("calc_direct")));
    }

    private void calculate() {
        driver.findElement(By.cssSelector("div[class='form_element']>input")).click();
    }

    private List<String> getCalculateData() {
        return driver.findElements(By.cssSelector("div[class*='whiteback']>div")).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Test(dataProvider = "dataProvider")
    public void test1(HashMap<String, Integer> dataProvider, List<String> expectedData) {
        dataProvider.forEach((key, value) -> {
            if (!key.equals("select_index")) {
                enter(key, value);
            } else {
                select().selectByIndex(value);
            }
        });
        calculate();
        Assert.assertEquals(expectedData, getCalculateData());
    }

    @DataProvider
    private Object[][] dataProvider() {
        return new Object[][]{
                {
                        new HashMap<String, Integer>() {{
                            put("calc_roomwidth", 5);
                            put("calc_roomheight", 7);
                            put("calc_lamwidth", 1200);
                            put("calc_lamheight", 195);
                            put("calc_inpack", 15);
                            put("calc_price", 350);
                            put("calc_bias", 200);
                            put("calc_walldist", 10);
                            put("select_index", 1);
                        }},
                        Arrays.asList("РЕЗУЛЬТАТ РАСЧЕТА:", "Площадь укладки: 34.76 м2.", "Кол-во панелей: 152 шт.", "Кол-во упаковок: 11 шт.", "Стоимость: 13513 руб.", "Остатки: 13 шт.", "Отрезки: 7 шт.")
                },
                {
                        new HashMap<String, Integer>() {{
                            put("calc_roomwidth", 9);
                            put("calc_roomheight", 6);
                            put("calc_lamwidth", 1000);
                            put("calc_lamheight", 210);
                            put("calc_inpack", 12);
                            put("calc_price", 200);
                            put("calc_bias", 220);
                            put("calc_walldist", 13);
                            put("select_index", 0);
                        }},
                        Arrays.asList("РЕЗУЛЬТАТ РАСЧЕТА:", "Площадь укладки: 53.61 м2.", "Кол-во панелей: 262 шт.", "Кол-во упаковок: 22 шт.", "Стоимость: 11088 руб.", "Остатки: 2 шт.", "Отрезки: 10 шт.")
                },
                {
                        new HashMap<String, Integer>() {{
                            put("calc_roomwidth", 3);
                            put("calc_roomheight", 4);
                            put("calc_lamwidth", 1750);
                            put("calc_lamheight", 200);
                            put("calc_inpack", 20);
                            put("calc_price", 300);
                            put("calc_bias", 180);
                            put("calc_walldist", 20);
                            put("select_index", 1);
                        }},
                        Arrays.asList("РЕЗУЛЬТАТ РАСЧЕТА:", "Площадь укладки: 11.72 м2.", "Кол-во панелей: 36 шт.", "Кол-во упаковок: 2 шт.", "Стоимость: 4200 руб.", "Остатки: 4 шт.", "Отрезки: 8 шт.")
                },
        };
    }

    @AfterTest
    public void postconditions() {
        driver.quit();
    }
}
