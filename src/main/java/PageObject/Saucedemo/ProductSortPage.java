package PageObject.Saucedemo;

import PageObject.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static driver.DriverCreation.getDriver;

public class ProductSortPage extends BasePage {
    private By productSortContainer = By.cssSelector(".product_sort_container");
    private By SortAz = By.xpath("//option[@value = \"az\"]");
    private By SortZa = By.xpath("//option[@value = \"za\"]");
    private By SortPriceLowHigh = By.xpath("//option[@value = \"lohi\"]");
    private By SortPriceHighLow = By.xpath("//option[@value = \"hilo\"]");
    private By products = By.xpath("//div[@class = 'inventory_item_name']");
    private By prices = By.xpath("//div[@class = 'inventory_item_price']");

    public ProductSortPage(WebDriver driver) {
        super(driver);
    }

    public ProductSortPage clickProductSortContainer() {
        click(productSortContainer);
        return this;
    }

    public enum Links{
        AZ,
        ZA,
        LOHI,
        HILO
    }

    public ProductSortPage clicklinks(Links links) {
        switch (links) {
            case AZ:
                click(SortAz);
                break;
            case ZA:
                click(SortZa);
                break;
            case LOHI:
                click(SortPriceLowHigh);
                break;
            case HILO:
                click(SortPriceHighLow);
                break;
        }
        return this;
    }

    public ProductSortPage checkSortNames(){
        List<String> actualData = getDriver().findElements(products).stream().map(data -> data.getText()).collect(Collectors.toList());
        List<String> expectedData = actualData.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(expectedData, actualData);
        return this;
    }

    public ProductSortPage checkReverseSortNames(){
        List<String> actualData = getDriver().findElements(products).stream().map(data -> data.getText()).collect(Collectors.toList());
        List<String> expectedData = actualData.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        Assert.assertEquals(expectedData, actualData);
        return this;
    }

    @Step("Check sort items on price from low to high")
    public ProductSortPage checkSortPrices(){
        List<Double> actualData = getDriver().findElements(prices).stream()
                .map(data -> data.getText().replace("$", ""))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        List<Double> expectedData = actualData.stream()
                .sorted()
                .collect(Collectors.toList());
        Assert.assertEquals(expectedData, actualData);
        return this;
    }

    @Step("Check sort items on price from high to low")
    public ProductSortPage checkReverseSortPrices(){
        List<Double> actualData = getDriver().findElements(prices).stream()
                .map(data -> data.getText().replace("$", ""))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        List<Double> expectedData = actualData.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        Assert.assertEquals(expectedData, actualData);
        return this;
    }
}
