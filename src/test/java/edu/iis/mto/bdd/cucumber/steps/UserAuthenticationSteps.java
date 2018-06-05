package edu.iis.mto.bdd.cucumber.steps;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.iis.mto.bdd.cucumber.pages.HomePage;
import edu.iis.mto.bdd.cucumber.pages.LoginPage;
import edu.iis.mto.bdd.model.FrequentFlyerMember;

public class UserAuthenticationSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void init() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Given("^(.*) is a registered Frequent Flyer$")
    public void givenARegisteredFrequentFlyer(String userEmail) {}

    @When("^(.*) authenticates with a valid email address and password$")
    public void whenJaneAuthenticatesWithAValidEmailAddressAndPassword(FrequentFlyerMember user) {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.open();
        loginPage.signInWithCredentials(user.getEmail(), user.getPassword());
    }

    @Then("^(.*) should be given access to (?:her|his) account$")
    public void thenTheUserShouldBeGivenAccessToAccount(FrequentFlyerMember user) {
        assertThat(new HomePage(driver, wait).getWelcomeMessage(), equalTo("Witaj " + user.getFirstName()));
    }

    @After
    public void close() {
        driver.close();
    }

}
