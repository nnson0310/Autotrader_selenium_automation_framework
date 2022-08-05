package page_objects;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page_interfaces.HomePageUI;

public class HomePage extends BasePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to SignUp/Login Header button")
    public void clickToHeaderLoginButton(WebDriver driver) {
        waitForElementClickable(driver, HomePageUI.HEADER_LOGIN_BUTTON);
        clickToElement(driver, HomePageUI.HEADER_LOGIN_BUTTON);
    }

    @Step("Click to Signup Tab")
    public void clickToSignupTab(WebDriver driver) {
        waitForElementClickable(driver, HomePageUI.AUTH_LOCK_SIGNUP_TAB);
        clickToElement(driver, HomePageUI.AUTH_LOCK_SIGNUP_TAB);
    }

    @Step("Enter to email textbox with email = {1} ")
    public void enterToEmailTextbox(WebDriver driver, String email) {
        waitForElementVisible(driver, HomePageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, HomePageUI.EMAIL_TEXTBOX, email);
    }

    @Step("Enter to password textbox with password = {1} ")
    public void enterToPasswordTextbox(WebDriver driver, String password) {
        waitForElementVisible(driver, HomePageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, HomePageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Enter to first_name textbox with first_name = {1} ")
    public void enterToFirstNameTextbox(WebDriver driver, String firstName) {
        waitForElementVisible(driver, HomePageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, HomePageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    @Step("Enter to last_name textbox with last_name = {1} ")
    public void enterToLastNameTextbox(WebDriver driver, String lastName) {
        waitForElementVisible(driver, HomePageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, HomePageUI.LAST_NAME_TEXTBOX, lastName);
    }

    @Step("Click to SignUp button")
    public void clickToSignUpButton(WebDriver driver) {
        waitForElementClickable(driver, HomePageUI.SIGNUP_BUTTON);
        clickToElement(driver, HomePageUI.SIGNUP_BUTTON);
    }

    @Step("Verify that username is displayed on header after sign up successfully")
    public boolean isUserNameDisplayedOnHeader(WebDriver driver, String username) {
        waitForElementVisible(driver, HomePageUI.USERNAME_HEADER_LABEL_DIV, username);
        return isElementDisplayed(driver, HomePageUI.USERNAME_HEADER_LABEL_DIV, username);
    }

    @Step("Click to Login Button")
    public void clickToLoginButton(WebDriver driver) {
        waitForElementClickable(driver, HomePageUI.LOGIN_BUTTON);
        clickToElement(driver, HomePageUI.LOGIN_BUTTON);
    }

    @Step("Verify that validation error = {1} is displayed")
    public boolean isValidationErrorMessageDisplayed(WebDriver driver, String message) {
        waitForElementVisible(driver, HomePageUI.VALIDATION_ERROR_LABEL_DIV, message);
        return isElementDisplayed(driver, HomePageUI.VALIDATION_ERROR_LABEL_DIV, message);
    }

    @Step("Verify that login error = {1} is displayed")
    public boolean isLoginErrorMessageDisplayed(WebDriver driver, String message) {
        waitForElementVisible(driver, HomePageUI.LOGIN_ERROR_LABEL_SPAN, message);
        return isElementDisplayed(driver, HomePageUI.LOGIN_ERROR_LABEL_SPAN, message);
    }
}
