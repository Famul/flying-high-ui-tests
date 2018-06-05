package edu.iis.mto.bdd.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriverWait wait;
    private WebDriver driver;

    @FindBy(name = "email")
    private WebElement email;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(name = "signin")
    private WebElement signIn;

    public LoginPage() {
        super();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);

    }

    public LoginPage(WebDriver driver) {
        super();
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super();
        this.wait = wait;
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void open() {
        driver.get(Pages.LOGIN_PAGE);
    }

    public void signInWithCredentials(String userEmail, String userPassword) {
        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys(userEmail);
        password.sendKeys(userPassword);
        signIn.click();
    }

}
