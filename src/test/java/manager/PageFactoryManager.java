package manager;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

}
