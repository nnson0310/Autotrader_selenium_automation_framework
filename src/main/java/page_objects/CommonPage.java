package page_objects;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page_interfaces.CommonPageUI;
import page_objects.home.HomePage;
import page_objects.member_centre.EditProfilePage;
import page_objects.member_centre.FavouritedCarPage;
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
    public HomePage clickToAutotraderLogo(WebDriver driver) {
        waitForElementClickable(driver, CommonPageUI.AUTOTRADER_LOGO);
        clickToElement(driver, CommonPageUI.AUTOTRADER_LOGO);
        return PageInitManager.getPageInitManager().getHomePage(driver);
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

    @Step("Hover to header navigation link = {1} and click to {2}")
    public void clickToHeaderNavigationLink(WebDriver driver, String navTopItem, String navSubItem) {
        waitForElementClickable(driver, CommonPageUI.HEADER_NAVIGATION_LINK, navTopItem);
        clickToElement(driver, CommonPageUI.HEADER_NAVIGATION_LINK, navTopItem);

        waitForElementClickable(driver, CommonPageUI.HEADER_NAV_SUB_ITEM_LINK, navSubItem);
        clickToElement(driver, CommonPageUI.HEADER_NAV_SUB_ITEM_LINK, navSubItem);
    }

    @Step("Verify that notify message = {1} is displayed")
    public boolean isNotifyDisplayed(WebDriver driver, String notifyMessage) {
        waitForElementVisible(driver, CommonPageUI.SUCCESS_NOTIFICATION, notifyMessage);
        return isElementDisplayed(driver, CommonPageUI.SUCCESS_NOTIFICATION, notifyMessage);
    }

    @Step("Click to heart icon on header to show all added car in favourite shortlist")
    public void clickToHeartIconOnHeader(WebDriver driver) {
        waitForElementClickable(driver, CommonPageUI.FAVOURITED_CAR_HEADER_NAV_COUNT_LABEL_DIV);
        clickToElement(driver, CommonPageUI.FAVOURITED_CAR_HEADER_NAV_COUNT_LABEL_DIV);
    }

    @Step("Verify that car name = {1} and sub title = {2} are displayed in favourite shortlist")
    public boolean isFavouritedCarsDisplayedInShortlist(WebDriver driver, String carName, String subTitle) {
        waitForElementVisible(driver, CommonPageUI.SHORTLIST_CARD_ITEM, carName, subTitle);
        return isElementDisplayed(driver, CommonPageUI.SHORTLIST_CARD_ITEM, carName, subTitle);
    }

    @Step("Get number of added favourite car counted on header")
    public int getAddedFavouriteCarCountOnHeader(WebDriver driver, String notifyMessage) {
        waitForStalenessOfElement(driver, CommonPageUI.SUCCESS_NOTIFICATION, notifyMessage);
        return Integer.parseInt(getElementText(driver, CommonPageUI.FAVOURITED_CAR_HEADER_NAV_COUNT_LABEL_SPAN));
    }

    @Step("Click to 'Show More' link of shortlist to go to Favourited_Cars page")
    public FavouritedCarPage clickToShowMoreShortlistLink(WebDriver driver) {
        waitForElementVisible(driver, CommonPageUI.SHORTLIST_SHOW_MORE_LINK);
        clickToElement(driver, CommonPageUI.SHORTLIST_SHOW_MORE_LINK);
        return PageInitManager.getPageInitManager().getFavouritedCarPage(driver);
    }

    @Step("Hover to 'Buy' header link and click to navigation link = {1)")
    public void clickToBuyHeaderNavItemLink(WebDriver driver, String navLink) {
        waitForElementVisible(driver, CommonPageUI.BUY_HEADER_NAVIGATION_LINK);
        hoverToElement(driver, CommonPageUI.BUY_HEADER_NAVIGATION_LINK);

        waitForElementClickable(driver, CommonPageUI.BUY_HEADER_NAV_SUB_ITEM_LINK, navLink);
        clickToElement(driver, CommonPageUI.BUY_HEADER_NAV_SUB_ITEM_LINK, navLink);
    }
}
