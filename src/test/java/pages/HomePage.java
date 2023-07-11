package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {
    @FindBy(xpath = "//*[@data-testid='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@data-testid='user-icon']")
    private WebElement userIcon;

    @FindBy(xpath = "//*[@id=\"hover-or-focus-tooltip\"]")
    private WebElement userNameSpan;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void makeLogin() {
        loginButton.click();
    }
    public void hoverUserIcon(long defaultTimeout) {
        Actions action = new Actions(driver);
        action.moveToElement(userIcon).perform();
    }

    public String getHoveredUserName() {
        return userNameSpan.getText();
    }

    public void waitVisibilityOfUserIcon(long defaultTimeout) {
        this.waitVisibilityOfElement(defaultTimeout, userIcon);
    }

    public void waitVisibilityOfUserName(long defaultTimeout) {
        this.waitVisibilityOfElement(defaultTimeout, userNameSpan);
    }
}
