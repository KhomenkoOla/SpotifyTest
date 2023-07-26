package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"login-username\"]")
    private WebElement loginInput;

    @FindBy(xpath = "//*[@id=\"username-error\"]/span/p")
    private WebElement loginErrorTextMessageBox;

    @FindBy(xpath = "//*[@id=\"login-password\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"password-error\"]")
    private WebElement passwordErrorTextMessageBox;

    @FindBy(xpath = "//*[@data-encore-id=\"banner\"]/span")
    private WebElement errorMessageSpan;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void setUserName(String userName) {
        new Actions(driver).moveToElement(loginInput).click();
        loginInput.sendKeys(userName);
    }

    public void setUserPassword(String userPassword) {
        new Actions(driver).moveToElement(passwordInput).click();
        passwordInput.sendKeys(userPassword);
    }

    public void makeLogin() {
        loginButton.click();
    }

    public boolean checkThatUrlIsLoginPage(final String expectedUrl) {
        return driver.getCurrentUrl().contains(expectedUrl);
    }

    public void clearUserName() {
        loginInput.clear();
        loginInput.sendKeys(Keys.SPACE, Keys.BACK_SPACE);
    }

    public void clearPassword() {
        passwordInput.clear();
        passwordInput.sendKeys(Keys.SPACE, Keys.BACK_SPACE);

    }

    public String getUserNameErrorMessage() {
        return loginErrorTextMessageBox.getText();
    }

    public String getPasswordErrorMessage() {
        return passwordErrorTextMessageBox.getText();
    }

    public String getSpanErrorMessage() {
        return errorMessageSpan.getText();
    }

    public void waitVisibilityErrorSpan(long defaultTimeout) {
        this.waitVisibilityOfElement(defaultTimeout, errorMessageSpan);
    }
    public void waitVisibilityLoginInput(long defaultTimeout) {
        this.waitVisibilityOfElement(defaultTimeout, loginInput);
    }
}
