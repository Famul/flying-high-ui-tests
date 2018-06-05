package edu.iis.mto.bdd.cucumber.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.iis.mto.bdd.cucumber.pages.Pages;

public class BookingAFlightSteps {

    private WebDriver driver;

    @Before
    public void init() {
        driver = new FirefoxDriver();
    }

    @Given("^I want to book a flight$")
    public void givenIWantToBookAFlight() {
        driver.get(Pages.LOGIN_PAGE);
        driver.findElement(By.linkText("Rezerwacja")).click();
    }

    @When("^I search for (.*) flights from (.*) to (.*) in (.*)$")
    public void whenISearchForFlights(String flightType, String from, String to, String travelClass) {
        driver.findElement(By.cssSelector("input[name='flightType'][value='" + flightType + "']")).click();
        driver.findElement(By.id("from")).sendKeys(from);
        driver.findElement(By.id("to")).sendKeys(to);
        WebElement travelClassElt = driver.findElement(By.id("travel-class"));
        new Select(travelClassElt).selectByVisibleText(travelClass);
    }

    @Then("^I should see the list of all available flights$")
    public void thenIShouldSeeTheListOfAllAvailableFlights() {}

    @When("^I enter ('.*') into the 'from' city field$")
    public void enterFromPrefix(String prefix) {}

    @Then("^I should see the following cities:$")
    public void shouldSeeCities(List<String> expectedCities) {

    }

}
