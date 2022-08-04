package page_objects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import page_interfaces.HomePageUI;

public class HomePage extends BasePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToHeaderLoginButton(WebDriver driver) {
        waitForElementClickable(driver, HomePageUI.HEADER_LOGIN_BUTTON);
        clickToElement(driver, HomePageUI.HEADER_LOGIN_BUTTON);
    }

    public void clickToSignupTab(WebDriver driver) {
        waitForElementClickable(driver, HomePageUI.AUTH_LOCK_SIGNUP_TAB);
        clickToElement(driver, HomePageUI.AUTH_LOCK_SIGNUP_TAB);
    }

    public void enterToEmailTextbox(WebDriver driver, String email) {
        waitForElementVisible(driver, HomePageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, HomePageUI.EMAIL_TEXTBOX, email);
    }

    public void enterToPasswordTextbox(WebDriver driver, String password) {
        waitForElementVisible(driver, HomePageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, HomePageUI.PASSWORD_TEXTBOX, password);
    }

    public void enterToFirstNameTextbox(WebDriver driver, String firstName) {
        waitForElementVisible(driver, HomePageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, HomePageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextbox(WebDriver driver, String lastName) {
        waitForElementVisible(driver, HomePageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, HomePageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void clickToSignUpButton(WebDriver driver) {
        waitForElementClickable(driver, HomePageUI.SIGNUP_BUTTON);
        clickToElement(driver, HomePageUI.SIGNUP_BUTTON);
    }

    public boolean isUserNameDisplayedOnHeader(WebDriver driver, String username) {
        waitForElementVisible(driver, HomePageUI.USERNAME_HEADER_LABEL_DIV, username);
        return isElementDisplayed(driver, HomePageUI.USERNAME_HEADER_LABEL_DIV, username);
    }
}
