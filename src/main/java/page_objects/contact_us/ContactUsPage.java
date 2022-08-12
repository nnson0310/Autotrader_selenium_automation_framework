package page_objects.contact_us;

import commons.GlobalConstants;
import helpers.FunctionHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page_interfaces.contact_us.ContactUsPageUI;
import page_objects.CommonPage;

public class ContactUsPage extends CommonPage {
    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Select to dropdown with enquiry type = {1}")
    public void selectToEnquiryTypeDropdown(WebDriver driver, String enquiryType) {
        waitForElementVisible(driver, ContactUsPageUI.ENQUIRY_TYPE_DROPDOWN);
        selectItemInDropDown(driver, ContactUsPageUI.ENQUIRY_TYPE_DROPDOWN, enquiryType);
    }

    @Step("Enter to message textarea with message = {1}")
    public void enterToMessageTextarea(WebDriver driver, String message) {
        waitForElementVisible(driver, ContactUsPageUI.MESSAGE_TEXTAREA);
        sendKeyToElement(driver, ContactUsPageUI.MESSAGE_TEXTAREA, message);
    }

    @Step("Click to 'Submit Questions' button")
    public void clickToSubmitQuestionButton(WebDriver driver) {
        waitForElementClickable(driver, ContactUsPageUI.SUBMIT_QUESTION_BUTTON);
        clickToElement(driver, ContactUsPageUI.SUBMIT_QUESTION_BUTTON);
    }

    @Step("Verify that enquiry submit success notification  = {1} is displayed")
    public boolean isEnquirySubmitSuccessNotificationDisplayed(WebDriver driver, String notify) {
        // Sometimes you need to add Thread Sleep to solve ReCaptcha manually
        FunctionHelper.sleepInSeconds(GlobalConstants.getGlobalConstants().getTinyTimeout());

        waitForElementVisible(driver, ContactUsPageUI.ENQUIRY_SUBMIT_SUCCESS_NOTIFICATION, notify);
        return isElementDisplayed(driver, ContactUsPageUI.ENQUIRY_SUBMIT_SUCCESS_NOTIFICATION, notify);
    }
}
