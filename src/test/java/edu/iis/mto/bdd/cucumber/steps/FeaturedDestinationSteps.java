package edu.iis.mto.bdd.cucumber.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.iis.mto.bdd.cucumber.pages.Pages;

/**
 * A description goes here. User: john Date: 6/10/13 Time: 9:13 PM
 */
public class FeaturedDestinationSteps {

    private WebDriver driver;

    @Before
    public void init() {
        driver = new FirefoxDriver();
    }

    @Given("^(.*) has logged on$")
    public void aUserHasLoggedOnAs(String user) {
        driver.get(Pages.LOGIN_PAGE);
        driver.findElement(By.name("email")).sendKeys("janina.kowalska@acme.com");
        driver.findElement(By.name("password")).sendKeys("s3cr3t");
        driver.findElement(By.name("signin")).click();
    }

    @When("^(?:.*) views the home page$")
    public void whenAUserViewsTheHomePage() {}

    @Then("^(?:she|he) should see ([0-9]+) featured destinations$")
    public void shouldSeeFeaturedDestinations(int featuredCount) {

    }

    @Then("^the featured destinations should include (.*) costing ([0-9]+)$")
    public void featuredDestinationsShouldInclude(String expectedDestination, int price) {

    }

    @After
    public void close() {
        driver.close();
    }
}
