package edu.iis.mto.bdd.cucumber.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.iis.mto.bdd.cucumber.workflowsteps.AuthenticationWorkFlowSteps;
import edu.iis.mto.bdd.model.FrequentFlyerMember;
import net.thucydides.core.annotations.Steps;

public class UserAuthenticationSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    @Steps
    AuthenticationWorkFlowSteps workflowSteps;

    @Before
    public void init() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        workflowSteps.init(driver, wait);
    }

    @Given("^(.*) is a registered Frequent Flyer$")
    public void givenARegisteredFrequentFlyer(String userEmail) {}

    @When("^(.*) authenticates with a valid email address and password$")
    public void whenJaneAuthenticatesWithAValidEmailAddressAndPassword(FrequentFlyerMember user) {
        workflowSteps.enterCredentialsFor(user);
    }

    @Then("^(.*) should be given access to (?:her|his) account$")
    public void thenTheUserShouldBeGivenAccessToAccount(FrequentFlyerMember user) {
        workflowSteps.verifyWelcomingMessageFor(user);
    }

    @After
    public void close() {
        driver.close();
    }

}
