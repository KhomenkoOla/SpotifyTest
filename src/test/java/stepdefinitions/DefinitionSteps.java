package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;
import pages.LoginPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.*;

public class DefinitionSteps {
    LoginPage loginPage;

    HomePage homePage;
    private static final long DEFAULT_TIMEOUT = 15000;
    WebDriver driver;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Given("User open main {string} page")
    public void openMainPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @When("User clicks home page login button")
    public void clicksLoginButtonOnHomePage() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.makeLogin();
    }

    @And("User check whether the home page has open {string}")
    public void checkThatUrlIsLoginPage(final String expectedUrl) {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.waitVisibilityLoginInput(DEFAULT_TIMEOUT);
        assertTrue(loginPage.checkThatUrlIsLoginPage(expectedUrl));
    }

    @And("User type any credentials {string}, {string}")
    public void fillCredentials(final String userName, final String password) {
        loginPage.setUserName(userName);
        loginPage.setUserPassword(password);
        loginPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User clear the inputs")
    public void clearCredentials() {
        loginPage.clearUserName();
        loginPage.clearPassword();
    }

    @And("User clicks login button")
    public void clicksLoginButtonOnLoginPage() {
        loginPage.makeLogin();
        loginPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("The user check the error messages")
    public void checksCredentialsErrorMessage() {
        assertFalse(loginPage.getUserNameErrorMessage().isEmpty());
        assertFalse(loginPage.getPasswordErrorMessage().isEmpty());
    }

    @Then("The user check the banner error messages")
    public void checksLoginErrorMessage() {
        loginPage.waitVisibilityErrorSpan(DEFAULT_TIMEOUT);
        assertFalse(loginPage.getSpanErrorMessage().isEmpty());
    }

    @Then("The user check logged in page with {string} name")
    public void checksSuccessLogin(final String userName) {
        homePage.waitVisibilityOfUserIcon(DEFAULT_TIMEOUT);
        homePage.hoverUserIcon(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfUserName(DEFAULT_TIMEOUT);
        assertEquals(homePage.getHoveredUserName(), userName);
    }

}
