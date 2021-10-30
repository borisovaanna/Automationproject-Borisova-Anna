package Task_20.steps;

import PageObject.Booking.HomePage;
import PageObject.Booking.HotelsPage;
import driver.BaseTestSelenide;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;

public class BookingHomePage_Steps extends BaseTestSelenide {

    @Given("go to {string}")
    public void goToUrl(String url) {
        open(url);

    }

    @When("enter hotel name, period and click search button")
    public void enterHotel(){
        get(HomePage.class)
                .enterHotel()
                .enterPeriod()
                .searchHotel();
    }

    @Then("check hotel name and it's score")
    public void checkHotelName(){
        get(HotelsPage.class)
                .checkHotelName()
                .checkHotelScore();
    }
}
