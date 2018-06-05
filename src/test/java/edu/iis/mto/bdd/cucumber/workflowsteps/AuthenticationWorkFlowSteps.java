package edu.iis.mto.bdd.cucumber.workflowsteps;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import edu.iis.mto.bdd.cucumber.pages.HomePage;
import edu.iis.mto.bdd.cucumber.pages.LoginPage;
import edu.iis.mto.bdd.model.FrequentFlyerMember;
import net.thucydides.core.annotations.Step;

public class AuthenticationWorkFlowSteps {

    private LoginPage loginPage;
    private HomePage homePage;

    public void init(WebDriver driver, WebDriverWait wait) {
        loginPage = new LoginPage(driver, wait);
        homePage = new HomePage(driver, wait);
    }

    @Step
    public void enterCredentialsFor(FrequentFlyerMember user) {
        loginPage.open();
        loginPage.signInWithCredentials(user.getEmail(), user.getPassword());
    }

    @Step
    public void verifyWelcomingMessageFor(FrequentFlyerMember user) {
        String welcomeMessage = homePage.getWelcomeMessage();
        assertThat(welcomeMessage, Matchers.equalTo("Witaj " + user.getFirstName()));
    }
}
