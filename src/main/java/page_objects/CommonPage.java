package page_objects;

import commons.BasePage;
import commons.GlobalConstants;
import helpers.FunctionHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page_interfaces.CommonPageUI;
import page_objects.profile.EditProfilePage;
import page_objects.sell_car.SellFeaturesPage;
import page_objects.sell_car.SellMyCarPage;

public class CommonPage extends BasePage {

    WebDriver driver;

    @Step("Click to SignUp/Login Header button")
    public void clickToHeaderLoginButton(WebDriver driver) {
        waitForElementClickable(driver, CommonPageUI.HEADER_LOGIN_BUTTON);
        clickToElement(driver, CommonPageUI.HEADER_LOGIN_BUTTON);
    }

    @Step("Click to Signup Tab")
    public void clickToSignupTab(WebDriver driver) {
        waitForElementClickable(driver, CommonPageUI.AUTH_LOCK_SIGNUP_TAB);
        clickToElement(driver, CommonPageUI.AUTH_LOCK_SIGNUP_TAB);
    }

    @Step("Enter to email textbox with email = {1} ")
    public void enterToEmailTextbox(WebDriver driver, String email) {
        waitForElementVisible(driver, CommonPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, CommonPageUI.EMAIL_TEXTBOX, email);
    }

    @Step("Enter to password textbox with password = {1} ")
    public void enterToPasswordTextbox(WebDriver driver, String password) {
        waitForElementVisible(driver, CommonPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, CommonPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Enter to first_name textbox in signup form with first_name = {1} ")
    public void enterToFirstNameTextboxInSignupForm(WebDriver driver, String firstName) {
        waitForElementVisible(driver, CommonPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, CommonPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    @Step("Enter to last_name textbox in signup form with last_name = {1} ")
    public void enterToLastNameTextboxInSignupForm(WebDriver driver, String lastName) {
        waitForElementVisible(driver, CommonPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, CommonPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    @Step("Click to SignUp button")
    public void clickToSignUpButton(WebDriver driver) {
        waitForElementClickable(driver, CommonPageUI.SIGNUP_BUTTON);
        clickToElement(driver, CommonPageUI.SIGNUP_BUTTON);
    }

    @Step("Verify that username is displayed on header after sign up successfully")
    public boolean isUserNameDisplayedOnHeader(WebDriver driver, String username) {
        waitForElementVisible(driver, CommonPageUI.USERNAME_HEADER_LABEL_DIV, username);
        return isElementDisplayed(driver, CommonPageUI.USERNAME_HEADER_LABEL_DIV, username);
    }

    @Step("Click to Login Button")
    public void clickToLoginButton(WebDriver driver) {
        waitForElementClickable(driver, CommonPageUI.LOGIN_BUTTON);
        clickToElement(driver, CommonPageUI.LOGIN_BUTTON);
    }

    @Step("Verify that validation error = {1} is displayed")
    public boolean isValidationErrorMessageDisplayed(WebDriver driver, String message) {
        waitForElementVisible(driver, CommonPageUI.VALIDATION_ERROR_LABEL_DIV, message);
        return isElementDisplayed(driver, CommonPageUI.VALIDATION_ERROR_LABEL_DIV, message);
    }

    @Step("Verify that login error = {1} is displayed")
    public boolean isLoginErrorMessageDisplayed(WebDriver driver, String message) {
        waitForElementVisible(driver, CommonPageUI.LOGIN_ERROR_LABEL_SPAN, message);
        return isElementDisplayed(driver, CommonPageUI.LOGIN_ERROR_LABEL_SPAN, message);
    }

    @Step("Hover to user_name header")
    public void hoverToUserNameHeader(WebDriver driver, String userName) {
        waitForElementVisible(driver, CommonPageUI.USERNAME_HEADER_LABEL_DIV, userName);
        hoverToElement(driver, CommonPageUI.USERNAME_HEADER_LABEL_DIV, userName);
    }

    @Step("Click to Edit_Profile link in dropdown")
    public EditProfilePage clickToEditProfileHeaderLink(WebDriver driver) {
        waitForElementClickable(driver, CommonPageUI.EDIT_PROFILE_HEADER_DROPDOWN_LINK);
        clickToElement(driver, CommonPageUI.EDIT_PROFILE_HEADER_DROPDOWN_LINK);
        return PageInitManager.getPageInitManager().getEditProfilePage(driver);
    }

    @Step("Click to 'Create My Free Ad' button in header")
    public SellMyCarPage clickToCreateMyFreeAdButton(WebDriver driver) {
        waitForElementClickable(driver, CommonPageUI.CREATE_MY_FREE_AD_BUTTON);
        clickToElement(driver, CommonPageUI.CREATE_MY_FREE_AD_BUTTON);
        return PageInitManager.getPageInitManager().getSellMyCarPage(driver);
    }

    @Step("Enter value = {1} to textbox with name attribute = {2} ")
    public void enterToDynamicTextboxByName(WebDriver driver, String value, String nameAttribute) {
        waitForElementClickable(driver, CommonPageUI.DYNAMIC_TEXTBOX_BY_NAME_ATTRIBUTE, nameAttribute);
        sendKeyToElement(driver, CommonPageUI.DYNAMIC_TEXTBOX_BY_NAME_ATTRIBUTE, value, nameAttribute);
    }

    @Step("Click to 'Autotrader' logo")
    public void clickToAutotraderLogo(WebDriver driver) {
        waitForElementClickable(driver, CommonPageUI.AUTOTRADER_LOGO);
        clickToElement(driver, CommonPageUI.AUTOTRADER_LOGO);
    }

    @Step("Click to footer link = {1}")
    public void clickToFooterLink(WebDriver driver, String footerLink) {
        waitForElementClickable(driver, CommonPageUI.DYNAMIC_FOOTER_LINK, footerLink);
        scrollToElement(driver, CommonPageUI.DYNAMIC_FOOTER_LINK, footerLink);
        clickToElement(driver, CommonPageUI.DYNAMIC_FOOTER_LINK, footerLink);
    }

    @Step("Switch to new tab and get page title")
    public String getPageTitleOfNewTab(WebDriver driver) {
        return super.getPageTitleOfNewTab(driver);
    }
}
